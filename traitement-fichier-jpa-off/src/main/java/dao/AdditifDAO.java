package dao;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import database.ConnectionDatabase;
import entities.Ingredient;
import entities.Magasin;
import interfaces.migrationCRUD.ICRUDMirgration;

public class AdditifDAO implements ICRUDMirgration{

	@Override
	public void insertCSV(List<Magasin> mag, ConnectionDatabase connection) throws IOException {
		this.formatteAddiif(mag);
		
	}
	
	public void formatteAddiif(List<Magasin> magasins) {
		Set<Ingredient> ingredients = new HashSet<>();
		
		magasins.stream()
				.forEach(e -> System.out.println(e.getAdditif()));
	}
}
