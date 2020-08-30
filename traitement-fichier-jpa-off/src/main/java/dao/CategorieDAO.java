package dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import database.ManagerConnection;
import entities.Categorie;
import entities.Magasin;
import interfaces.migrationCRUD.ICRUDMirgration;
import transactiondb.Transaction;
import utils.StringFormatter;

/**
 * 
 * @author Jordan
 *
 */
public class CategorieDAO implements ICRUDMirgration {
	
	public CategorieDAO() {}
	
	@Override
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException {
		EntityManager manager = ManagerConnection.initConnection();
		Transaction.startTransaction(manager);
		
		Set<Categorie> list = this.suppressionDoublonCategorie(mag);
		for(Categorie p : list) {
			manager.persist(p);
		}
		Transaction.commitTransaction(manager);
	}
	
	public Set<Categorie> suppressionDoublonCategorie(List<Magasin> magasins) {
		return magasins.stream()
					   .map(m -> this.createCategorie(m))
					   .distinct()
					   .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Categorie::getNom))));
		
	}
	
	/**
	 * Retourne un objet Categorie avec le nom formatter
	 * @param m
	 * @return
	 */
	private Categorie createCategorie(Magasin m) {
		return new Categorie(StringFormatter.sansAccent(m.getProduit().getCategorie().getNom()));
	}
}
