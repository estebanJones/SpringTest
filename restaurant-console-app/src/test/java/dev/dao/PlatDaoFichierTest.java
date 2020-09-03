package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.dao.PlatDaoFichier;

@SpringJUnitConfig({PlatDaoFichier.class})
@TestPropertySource("classpath:test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PlatDaoFichierTest {

	@Autowired
	private PlatDaoFichier dao;
	
	
	@Test
	public void ajouterPlat() {
		dao.ajouterPlat("saumon", 3000);
		assertThat(dao.listerPlats().get(0).getNom().equalsIgnoreCase("saumon"));
	}

}
