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
import entities.Categorie;
import entities.Magasin;
import entities.Produit;
import interfaces.ICategorieMigration;
import transactiondb.Transaction;
import utils.StringFormatter;

public class CategorieDAO implements ICategorieMigration {
	
	public CategorieDAO() {}
	
	@Override
	public void insertCSV(List<Magasin> mag, ConnectionDatabase connection) throws IOException {
		EntityManager manager = connection.initConnection();
		Transaction.startTransaction(manager);
		
		Set<Categorie> list = this.suppressionDoublonCategorie(mag);
		for(Categorie p : list) {
			
			manager.persist(p);
		}
		Transaction.commitTransaction(manager);
		connection.closeConnection();
	}
	
	public Set<Categorie> suppressionDoublonCategorie(List<Magasin> magasins) {
		return magasins.stream()
					   .map(m -> this.createCategorie(m))
					   .distinct()
					   .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Categorie::getNom))));
		
	}
	
	private Categorie createCategorie(Magasin m) {
		return new Categorie(this.formatteNom(m.getProduit().getCategorie().getNom()));
	}
	
	public String formatteNom(String str) {
		return StringFormatter.sansAccent(StringUtils.substringBefore(str, ",")).toLowerCase();
	}
}
