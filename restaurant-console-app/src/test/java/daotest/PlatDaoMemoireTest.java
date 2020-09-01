package daotest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.dao.PlatDaoMemoire;

class PlatDaoMemoireTest {
	private PlatDaoMemoire platDaoMemoire;
	
	@BeforeEach
	public void init() {
		PlatDaoMemoire platDaoMemoire = new PlatDaoMemoire();
	}
	
	
	@Test
	public void listerPlatsVideInitialisation() {
		platDaoMemoire.listerPlats();
	}
	
	@Test
	public void ajouterPlatCasPassants() {
		
	}

}
