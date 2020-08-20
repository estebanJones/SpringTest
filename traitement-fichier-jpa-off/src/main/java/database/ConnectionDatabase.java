package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDatabase {
	private EntityManager em;
	private EntityManagerFactory factory;
	private static final String PERSISTANCEAME = "bdd_foodFact";
	
	public ConnectionDatabase() {
		
	}
	
	/**
	 * demarre une connection à la bdd et retourne un EntityManager
	 * @return EntityManager
	 */
	public EntityManager initConnection() {
		factory = Persistence.createEntityManagerFactory(ConnectionDatabase.PERSISTANCEAME);
		return factory.createEntityManager();
		
	}
	
	/**
	 * Ferme la connection à la base de donnée
	 */
	public void closeConnection() {
		em.close();
		factory.close();
	}
}
