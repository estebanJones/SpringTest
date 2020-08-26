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
import entities.Magasin;
import entities.Marque;
import interfaces.migrationCRUD.ICRUDMirgration;
import transactiondb.Transaction;
import utils.StringFormatter;

public class MarqueDAO implements ICRUDMirgration{

	public MarqueDAO() {}
	
	/**
	 * Insert les marques recuperé dans le csv vers la bdd
	 */
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException {
		EntityManager manager = connection.initConnection();
		Transaction.startTransaction(manager);
		Set<Marque> marques = this.suppressionDoublon(mag);
		for(Marque m : marques) {
			manager.persist(m);
		}
		Transaction.commitTransaction(manager);
	}
	
	/**
	 * Supprime les doublons en prenant en compte les accents
	 * @param List<Magasin> magasins
	 * @return Set<Marque>
	 */
	public Set<Marque> suppressionDoublon(List<Magasin> magasins) {
		return  magasins.stream()
						.map(m -> new Marque(StringFormatter.sansAccent(StringUtils.substringBefore(m.getProduit().getMarque().getNom(), ","))))
						.distinct()
						.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Marque::getNom))));				
	}		
	
}
