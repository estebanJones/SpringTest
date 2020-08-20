package dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import database.ConnectionDatabase;
import entities.Magasin;
import entities.Marque;
import entities.Produit;
import interfaces.IProduitMigration;
import transactiondb.Transaction;
import utils.StringFormatter;

public class ProduitDAO implements IProduitMigration {

	public ProduitDAO() {}
	
	@Override
	public void insertCSV(List<Magasin> mag, ConnectionDatabase connection) throws IOException {
		EntityManager manager = connection.initConnection();
		Transaction.startTransaction(manager);
		Set<Produit> produits = this.suppressionDoublonProduit(mag);
		for(Produit m : produits) {
			System.out.println(m.getNom());
			manager.persist(m);
		}

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
		System.out.println(m.getProduit().getMarque().getId());
		produit.setCategorie(m.getProduit().getCategorie());
		return produit;
	}
	
	public String formatteNom(String str) {
		return StringFormatter.sansAccent(StringUtils.substringBefore(str, ",")).toLowerCase();
	}
}
