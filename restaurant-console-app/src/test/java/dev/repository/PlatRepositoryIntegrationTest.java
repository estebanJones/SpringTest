package dev.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.config.JpaConfig;
import dev.entite.Plat;

@SpringJUnitConfig({ JdbcTestConfig.class, JpaConfig.class })
@ActiveProfiles("jpaconf")
public class PlatRepositoryIntegrationTest {
	@Autowired
	private PlatRepository platRepository;
	
	@Test
	public void testFindAll() {
		System.out.println("heelo" + platRepository);
		List<Plat> plats = platRepository.findAll();
		System.out.println(plats);
	}
}
