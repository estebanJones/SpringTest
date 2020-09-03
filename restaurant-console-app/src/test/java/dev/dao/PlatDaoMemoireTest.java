package dev.dao;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.dao.PlatDaoMemoire;
import dev.entite.Plat;

class PlatDaoMemoireTest {
	private PlatDaoMemoire platDaoMemoire;
	
	@BeforeEach
	public void init() {
		platDaoMemoire = new PlatDaoMemoire();
	}
	
	public void listerPlatsVideInitialisation() {
		List<Plat> list = platDaoMemoire.listerPlats();
		assertThat(list.isEmpty());
	}
	
	@Test
	public void ajouterPlatCasPassants() {
		
		Plat plat = new Plat("Looool", 6);
		platDaoMemoire.ajouterPlat("Looool", 6);
		
		List<Plat> list = platDaoMemoire.listerPlats();

		assertThat(list.get(0).getNom().equalsIgnoreCase(plat.getNom()));
	}

}
