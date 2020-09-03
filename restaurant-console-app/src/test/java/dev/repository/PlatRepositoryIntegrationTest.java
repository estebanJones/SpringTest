package dev.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;

import org.assertj.core.data.Index;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import dev.config.JdbcTestConfig;
import dev.config.JpaConfig;
import dev.entite.Ingredient;
import dev.entite.Plat;

@SpringJUnitConfig({ JdbcTestConfig.class, JpaConfig.class })
public class PlatRepositoryIntegrationTest {

	@Autowired
	private PlatRepository platRepository;
	
	@Test
	void testFindAll() {

		assertThat(platRepository.findAll()).isNotEmpty();

	}

	@Test
	void testFindAllSortAsc() {

		List<Plat> listPlat = platRepository.findAll(Sort.by(Sort.Direction.ASC, "nom"));

		assertThat(listPlat).isSortedAccordingTo(Comparator.comparing(Plat::getNom));

	}

	@Test
	void testFindAllSortDesc() {

		List<Plat> listPlat = platRepository.findAll(Sort.by(Sort.Direction.DESC, "nom"));

		assertThat(listPlat).isSortedAccordingTo(Comparator.comparing(Plat::getNom).reversed());

	}

	@Test
	void testFindAllPageable() {

		Pageable firstPageWithTwoElements = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "nom"));

		Page<Plat> pagePlat = platRepository.findAll(firstPageWithTwoElements);

		assertThat(pagePlat.getSize()).isEqualTo(2);
		assertThat(pagePlat.getContent().get(0).getId()).isEqualTo(4);

	}

	@Test
	void testFindById() {

		Plat plat = platRepository.findById(4).get();

		assertThat(plat.getNom()).isEqualTo("Blanquette de veau");
		assertThat(plat.getPrixEnCentimesEuros()).isEqualTo(1500);

	}

	@Test
	@Transactional
	void testGetOne() {

		Plat plat = platRepository.getOne(2);

		assertThat(plat.getNom()).isEqualTo("Moules-frites");
		assertThat(plat.getPrixEnCentimesEuros()).isEqualTo(1300);

	}

	@Test
	void testCount() {

		Long total = platRepository.count();

		assertThat(total).isEqualTo(platRepository.findAll().size());

	}

	@Test
	void testFindByPrix() {

		List<Plat> platByPrix = platRepository.findByPrixEnCentimesEuros(1300);

		assertThat(platByPrix.size()).isEqualTo(2);
		assertThat(platByPrix.get(0).getNom()).isEqualTo("Magret de canard");

	}

	@Test
	void testAvgPrix() {
		Double moyenne = platRepository.findByAvgPrixSuppA(0);
		Double moyenneAvecFindAll = 0.0;
		
		List<Plat> listPlat = platRepository.findAll();
		for (Plat plat : listPlat) {
			moyenneAvecFindAll += plat.getPrixEnCentimesEuros();
		}
		
		assertThat(moyenne).isEqualTo(moyenneAvecFindAll / listPlat.size());
	}

	@Test
	void findIngredientsByPlatNom() {
		List<Ingredient> listIngDePlat = platRepository.findIngredientsByPlatNom("Moules-frites");

		assertThat(listIngDePlat.size()).isEqualTo(6);
		assertThat(listIngDePlat.get(0).getNom()).isEqualTo("Moule");
	}

	@Test
	void testSave() {
		List<Plat> listPlat = platRepository.findAll();

		Plat plat = new Plat();
		plat.setNom("Pizza");
		plat.setPrixEnCentimesEuros(1400);

		platRepository.save(plat);

		assertThat(platRepository.findAll().size()).isEqualTo(listPlat.size() + 1);

		listPlat = platRepository.findAll();

		assertThat(listPlat.get(listPlat.size() - 1).getNom()).isEqualTo(plat.getNom());
	}

	@Test
	@Transactional
	void testChangerNom() {

		platRepository.updateNomPlat("Couscous", "Couscous-Merguez");

		List<Plat> listPlat = platRepository.findAll();

		assertThat(listPlat).extracting(p -> p.getNom()).contains("Couscous-Merguez", Index.atIndex(2));

	}
}
