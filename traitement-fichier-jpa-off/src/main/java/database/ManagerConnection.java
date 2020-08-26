package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerConnection {
	private EntityManager em;
	private static EntityManagerFactory factory;
	private static final String PERSISTANCEAME = "bdd_foodFact";
	
	public ManagerConnection() {
		
	}
	
	/**
	 * demarre une connection à la bdd et retourne un EntityManager
	 * @return EntityManager
	 */
	public static EntityManager initConnection() {
		factory = Persistence.createEntityManagerFactory(ManagerConnection.PERSISTANCEAME);
		return factory.createEntityManager();
		
	}
}
