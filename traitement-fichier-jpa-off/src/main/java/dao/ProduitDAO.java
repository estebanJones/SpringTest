package dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import database.ManagerConnection;
import entities.Categorie;
import entities.Magasin;
import entities.Marque;
import entities.Produit;
import interfaces.bddCRUD.IProduitBDD;
import interfaces.migrationCRUD.ICRUDMirgration;
import transactiondb.Transaction;
import utils.StringFormatter;

public class ProduitDAO implements ICRUDMirgration, IProduitBDD {
	MarqueDAO marqueDAO = new MarqueDAO();
	CategorieDAO categorieDAO = new CategorieDAO();

	public ProduitDAO() {}
	@Override
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException {
		EntityManager manager = ManagerConnection.initConnection();
		Transaction.startTransaction(manager);
		
		List<Object> resultatRequeteCategorie = this.selectAll(manager, "Categorie");
		List<Object> resultatRequeteMarque = this.selectAll(manager, "Marque");
		Set<Produit> produits = this.suppressionDoublonProduit(mag);
		
		this.produitLinked(resultatRequeteMarque, resultatRequeteCategorie, produits).forEach(e -> {
				System.out.println(e);
				manager.persist(e);
			}
			
		);
		
		Transaction.commitTransaction(manager);
	}
	
	public Set<Produit> produitLinked(List<Object> resultatRequeteMarque, List<Object> resultatRequeteCategorie, Set<Produit> produits) {
		Set<Produit> produitCategorieLinked = this.linkProduitCategorie(resultatRequeteCategorie, produits);
		return this.linkProduitMarque(resultatRequeteMarque, produitCategorieLinked);
	}
	
	public Set<Produit> linkProduitMarque(List<Object> resultatRequeteMarque, Set<Produit> produits) {
		Set<Produit> marqueProduitLinked = new HashSet<>();
		
		for(Produit p : produits) {
			resultatRequeteMarque.forEach(e -> {
				Marque marque = (Marque) e;
				if(marque.getNom().equalsIgnoreCase(p.getMarque().getNom())) {
					p.setCategorie(p.getCategorie());
					p.setMarque(marque);

					marqueProduitLinked.add(p);
				}
			});
		}
		return marqueProduitLinked;
	}
	
	public Set<Produit> linkProduitCategorie(List<Object> resultatRequeteCategorie, Set<Produit> produits) {
		Set<Produit> categorieProduitLinked = new HashSet<>();
		
		for(Produit p : produits) {
			resultatRequeteCategorie.forEach(e -> {
				Categorie categorie = (Categorie) e;
				if(categorie.getNom().equalsIgnoreCase(p.getCategorie().getNom())) {
					p.setCategorie(categorie);
					categorieProduitLinked.add(p);
				}
				
			});
		}
		return categorieProduitLinked;
	}
	
	
	public Set<Produit> suppressionDoublonProduit(List<Magasin> magasins) {
		return magasins.stream()
					   .map(m -> m.getProduit())
					   .distinct()
					   .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Produit::getNom))));	
	}
	
	
	private String formatteNom(String str) {
		return StringFormatter.sansAccent(StringUtils.substringBefore(str, ",")).toLowerCase();
	}
}
