package dev.dao;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.config.AppConfig;
import dev.entite.Plat;
import dev.exception.PlatException;
import dev.service.PlatServiceVersion1;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestPropertySource("classpath:test.properties")
public class PlatVersion1Test {
	private IPlatDao dao;
	private PlatServiceVersion1 service;
	
	@BeforeEach
	public void init() {
		dao = Mockito.mock(IPlatDao.class);
		this.service = new PlatServiceVersion1(dao);
	}
	
	@Test
	public void ajouterPlatInvalideNom() {
		PlatException exception = assertThrows(PlatException.class, () -> dao.ajouterPlat("c", 8756686));
		assertThat(exception.getMessage().equalsIgnoreCase("un plat doit avoir un nom de plus de 3 caractères"));
	
	}
	
	@Test
	public void ajouterPlatInvalidePrix() {
		PlatException exception = assertThrows(PlatException.class, () -> dao.ajouterPlat("couscous", 1));
		assertThat(exception.getMessage().equalsIgnoreCase("le prix d'un plat doit être supérieur à 5 €"));
	
	}
	
	@Test
	public void ajouterPlatTestValide() {
		Plat plat1 = new Plat("poisson", 2000);
		Mockito.when(dao.listerPlats()).thenReturn(Arrays.asList(plat1));
		
		List<Plat> liste = dao.listerPlats();
		this.service.ajouterPlat("poisson", 2000);
		assertThat(liste.get(0).getNom().equalsIgnoreCase("poisson"));
		assertThat(liste.get(0).getPrixEnCentimesEuros() == 10);
	}
}
