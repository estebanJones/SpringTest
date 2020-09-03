package dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.entite.Plat;

@Repository
@Profile("jpaconf")
public class PlatDaoJpa implements IPlatDao{
	@PersistenceContext EntityManager em;
	
	@Override
	public List<Plat> listerPlats() {
		String hql = "SELECT p FROM Plat p";
		return em.createQuery(hql, Plat.class).getResultList();
	}

	@Override
	@Transactional
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		this.em.persist(new Plat(nomPlat, prixPlat));
	}

}
