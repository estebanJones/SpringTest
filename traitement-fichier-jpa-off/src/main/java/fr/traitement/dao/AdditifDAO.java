package fr.traitement.dao;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.traitement.database.ManagerConnection;
import fr.traitement.entities.Ingredient;
import fr.traitement.entities.Magasin;
import fr.traitement.interfaces.migrationCrud.ICRUDMirgration;

public class AdditifDAO implements ICRUDMirgration{

	@Override
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException {
		this.formatteAddiif(mag);
		
	}
	
	public void formatteAddiif(List<Magasin> magasins) {
		Set<Ingredient> ingredients = new HashSet<>();
		
		magasins.stream()
				.forEach(e -> System.out.println(e.getAdditif()));
	}
}
