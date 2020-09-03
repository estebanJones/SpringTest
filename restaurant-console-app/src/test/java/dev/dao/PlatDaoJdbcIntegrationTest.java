package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.dao.PlatDaoJdbc;
import dev.entite.Plat;


@SpringJUnitConfig({PlatDaoJdbc.class, JdbcTestConfig.class})
@ActiveProfiles("jdbc")
public class PlatDaoJdbcIntegrationTest {
	@Autowired
	private PlatDaoJdbc platDaoJdbc;
	@Autowired
	private JdbcTestConfig jdbcTestConfig;

	
	@Test
	public void listerPlatsNonVide() {
		List<Plat> plats = this.platDaoJdbc.listerPlats();
		assertThat(plats).isNotEmpty();
		
	}
	
	public void ajouterPlat() {
		this.platDaoJdbc.ajouterPlat("lool", 3000);
	}
}
