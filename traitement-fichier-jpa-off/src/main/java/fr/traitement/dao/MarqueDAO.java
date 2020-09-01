package fr.traitement.dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import fr.traitement.database.ManagerConnection;
import fr.traitement.entities.Magasin;
import fr.traitement.entities.Marque;
import fr.traitement.interfaces.migrationCrud.ICRUDMirgration;
import fr.traitement.transactiondb.Transaction;
import fr.traitement.utils.StringFormatter;

/**
 * 
 * @author Jordan
 *
 */
public class MarqueDAO implements ICRUDMirgration{

	public MarqueDAO() {}
	
	/**
	 * Insert les marques recuperé dans le csv vers la bdd
	 */
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException {
		EntityManager manager = ManagerConnection.initConnection();
		Transaction.startTransaction(manager);
		
		Set<Marque> marques = this.suppressionDoublon(mag);
		marques.forEach(marque -> manager.persist(marque));

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
