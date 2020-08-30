package dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import database.ManagerConnection;
import database.ManagerLinkProduit;
import entities.Magasin;
import entities.Produit;
import enums.TableEnum;
import interfaces.bddCRUD.IProduitBDD;
import interfaces.migrationCRUD.ICRUDMirgration;
import transactiondb.Transaction;

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
