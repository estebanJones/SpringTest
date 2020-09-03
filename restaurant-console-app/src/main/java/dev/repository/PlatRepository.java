package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Ingredient;
import dev.entite.Plat;

public interface PlatRepository extends JpaRepository<Plat, Integer>{
	List<Plat> findAll();
	Plat findByNom();
	void updateNomPlat(String ancienNom, String nouveauNom);
	List<Ingredient> findIngredientsByPlatNom(String platNom);
	Double findByAvgPrixSuppA(Integer prix);
	List<Plat> findByPrixEnCentimesEuros(Integer prixEnCentimes);
}
