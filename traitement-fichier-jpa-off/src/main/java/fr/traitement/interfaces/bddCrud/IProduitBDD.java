package fr.traitement.interfaces.bddCrud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public interface IProduitBDD {
	public default List<Object> selectAll(EntityManager manager, String className) {
		Query query = manager.createQuery("SELECT c FROM " + className +  " c");
		return query.getResultList();
	}
}
