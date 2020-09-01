package fr.traitement.dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import fr.traitement.database.ManagerConnection;
import fr.traitement.database.ManagerLinkProduit;
import fr.traitement.entities.Magasin;
import fr.traitement.entities.Produit;
import fr.traitement.enums.TableEnum;
import fr.traitement.interfaces.bddCrud.IProduitBDD;
import fr.traitement.interfaces.migrationCrud.ICRUDMirgration;
import fr.traitement.transactiondb.Transaction;

public class ProduitDAO implements ICRUDMirgration, IProduitBDD {
	MarqueDAO marqueDAO = new MarqueDAO();
	CategorieDAO categorieDAO = new CategorieDAO();

	public ProduitDAO() {}
	@Override
	public void insertCSV(List<Magasin> magasin, ManagerConnection connection) throws IOException {
		EntityManager manager = ManagerConnection.initConnection();
		Transaction.startTransaction(manager);
		
		this.constructProduit(magasin, manager).forEach(e -> manager.persist(e));
		
		Transaction.commitTransaction(manager);
	}
	
	/**
	 * Va construire un Set<Produit> avec les liaisons 
	 * @param magasin
	 * @param manager
	 * @return
	 */
	private Set<Produit> constructProduit(List<Magasin> magasin, EntityManager manager) {
		List<Object> resultatRequeteCategorie = this.selectAll(manager, TableEnum.CATEGORIE.toString());
		List<Object> resultatRequeteMarque = this.selectAll(manager, TableEnum.MARQUE.toString());
		Set<Produit> produits = this.suppressionDoublonProduit(magasin);
		
		return ManagerLinkProduit.produitLinked(resultatRequeteMarque, resultatRequeteCategorie, produits);
	}
	
	private Set<Produit> suppressionDoublonProduit(List<Magasin> magasins) {
		return magasins.stream()
					   .map(m -> m.getProduit())
					   .distinct()
					   .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Produit::getNom))));	
	}
}
