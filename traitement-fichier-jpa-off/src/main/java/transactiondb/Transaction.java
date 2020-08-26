package transactiondb;

import javax.persistence.EntityManager;

public class Transaction {
	/**
	 * Demarre une transaction avec la BDD
	 * @param EntityManager em
	 */
	public static void startTransaction(EntityManager em) {
		em.getTransaction().begin();
	}
	
	/**
	 * Commit une transaction avec la BDD
	 * @param EntityManager em
	 */
	public static void commitTransaction(EntityManager em) {
		em.getTransaction().commit();
	}
}
