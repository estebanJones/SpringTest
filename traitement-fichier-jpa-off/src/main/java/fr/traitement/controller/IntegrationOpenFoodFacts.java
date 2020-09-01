package fr.traitement.controller;

import java.io.IOException;
import java.util.List;

import fr.traitement.database.ManagerConnection;
import fr.traitement.entities.Magasin;
import fr.traitement.exceptions.TechnicalException;
import fr.traitement.services.EntiteMigrationService;
import fr.traitement.services.ReaderService;



public class IntegrationOpenFoodFacts {
	public static void main(String[] args) throws TechnicalException {
		ReaderService readerService = new ReaderService();
		EntiteMigrationService entiteMigrationService = EntiteMigrationService.getInstance();
		ManagerConnection connection = new ManagerConnection();
		List<Magasin> mag;
		
		try {
			mag = readerService.readFile();
			entiteMigrationService.persistEntities(mag, connection);
		} catch (IOException e) {
			throw new TechnicalException("Une erreur technique est survenue !");
		}
		entiteMigrationService.close();
	}
}
