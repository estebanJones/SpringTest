package servicestest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import dev.dao.IPlatDao;
import dev.entite.Plat;
import dev.exception.PlatException;
import dev.service.PlatServiceVersion1;

class PlatServiceService1Test {
	private IPlatDao dao;
	private PlatServiceVersion1 service1;
	
	@BeforeEach
	public void init() {
		dao = Mockito.mock(IPlatDao.class);
		service1 = new PlatServiceVersion1(dao);
	}
	
	
	@Test
	public void ajouterPlatTestValide() {
		Plat plat1 = new Plat("poisson", 2000);
		Mockito.when(dao.listerPlats()).thenReturn(Arrays.asList(plat1));
		
		List<Plat> liste = dao.listerPlats();
		service1.ajouterPlat("poisson", 2000);
		assertThat(liste.get(0).getNom().equalsIgnoreCase("poisson"));
		assertThat(liste.get(0).getPrixEnCentimesEuros() == 10);
	}
	
	@Test
	public void ajouterPlatTestInvalide() {
		Assertions.assertThrows(PlatException.class, () -> service1.ajouterPlat("p", 2000));
	}
}
