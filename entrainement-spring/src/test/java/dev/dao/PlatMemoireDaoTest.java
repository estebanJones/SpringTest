package dev.dao;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.entite.Plat;



public class PlatMemoireDaoTest {
	private PlatDaoMemoire platDaoMemoire;

	@BeforeEach
	void setUp(){
		this.platDaoMemoire= new PlatDaoMemoire();
	}

    @Test
	void listerPlatsVideALInitialisation(){
		List<Plat> plats = this.platDaoMemoire.listerPlats();
		assertThat(plats).isEmpty();
	}
		
	@Test
	void ajouterPlatCasPassants(){
		this.platDaoMemoire.ajouterPlat("couscous", 586586);
		assertThat(this.platDaoMemoire.listerPlats().get(0).getNom().equalsIgnoreCase("couscous"));
		assertThat(this.platDaoMemoire.listerPlats().get(0).getPrixEnCentimesEuros().equals(586586));
		
	}
	
}
