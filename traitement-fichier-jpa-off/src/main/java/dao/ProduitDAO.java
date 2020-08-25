package dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import database.ConnectionDatabase;
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
	public void insertCSV(List<Magasin> mag, ConnectionDatabase connection) throws IOException {
		Set<Produit> produitListe = new HashSet<>();
		Set<Produit> produitListe2 = new HashSet<>();
		
		EntityManager manager = connection.initConnection();
		Transaction.startTransaction(manager);
		
		Query query = manager.createQuery("SELECT c FROM Categorie c");
		List<Categorie> c = query.getResultList();
		
		Query query1 = manager.createQuery("SELECT m FROM Marque m");
		List<Marque> m = query1.getResultList();
		
		Set<Produit> produits = this.suppressionDoublonProduit(mag);
		for(Produit p : produits) {
			c.forEach(e -> {
				if(e.getNom().equalsIgnoreCase(p.getCategorie().getNom())) {
					p.getCategorie().setId(e.getId());
					p.getCategorie().setNom(e.getNom());
					produitListe.add(p);
				}
				
			});
		}
		
		for(Produit p : produitListe) {
			m.forEach(e -> {
				if(e.getNom().equalsIgnoreCase(p.getMarque().getNom())) {
					Produit produit = new Produit(p.getNom());
					p.setCategorie(p.getCategorie());
					p.getMarque().setNom(e.getNom());
					p.getMarque().setId(e.getId());
					
					produitListe2.add(p);
				}
			});
		}
		
		//produitListe2.forEach(e -> manager.persist(e));
		Transaction.commitTransaction(manager);
		connection.closeConnection();
	}

	
	public Set<Produit> suppressionDoublonProduit(List<Magasin> magasins) {
		return magasins.stream()
					   .map(m -> this.createProduit(m))
					   .distinct()
					   .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Produit::getNom))));	
	}
	
	private Produit createProduit(Magasin m) {
		Produit produit = new Produit(this.formatteNom(m.getProduit().getNom()));
		produit.setMarque(m.getProduit().getMarque());
		produit.setCategorie(m.getProduit().getCategorie());
		produit.setNutriment(m.getNutriment());
		return produit;
	}
	
	public String formatteNom(String str) {
		return StringFormatter.sansAccent(StringUtils.substringBefore(str, ",")).toLowerCase();
	}
}
