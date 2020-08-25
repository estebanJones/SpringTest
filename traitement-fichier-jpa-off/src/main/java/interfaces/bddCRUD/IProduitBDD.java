package interfaces.bddCRUD;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public interface IProduitBDD {
	public default Object selectAll(EntityManager manager, String className) {
		Query query = manager.createQuery("SELECT c FROM " + className +  " c");
		return query.getResultList();
	}
}
