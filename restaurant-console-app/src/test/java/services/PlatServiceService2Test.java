package services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.dao.IPlatDao;
import dev.dao.PlatDaoMemoire;
import dev.entite.Plat;
import dev.exception.PlatException;
import dev.service.PlatServiceVersion2;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PlatServiceVersion2.class, PlatDaoMemoire.class})
class PlatServiceService2Test {
	@Autowired
	private PlatServiceVersion2 service2;
	@Autowired
	private IPlatDao dao;
	
	@BeforeEach
	public void init() {
		dao = Mockito.mock(PlatDaoMemoire.class);
	}
	
	@Test
	public void ajouterPlatTestValide() {
		Plat plat1 = new Plat("lololo", 2000);
		Mockito.when(dao.listerPlats()).thenReturn(Arrays.asList(plat1));
		List<Plat> listePlat = service2.listerPlats();
		
		service2.ajouterPlat("lololo", 2000);
		System.out.println(listePlat.size());
		
		assertThat(listePlat.get(0).getNom().equalsIgnoreCase("lololo"));
		assertThat(listePlat.get(0).getPrixEnCentimesEuros() == 2000);
	}
	
	@Test
	public void ajouterPlatTestInvalide() {
		assertThrows(PlatException.class, () -> service2.ajouterPlat("l", 2000));
	}
	
}
