package controller;

import java.io.IOException;
import java.util.List;

import database.ManagerConnection;
import entities.Magasin;
import exceptions.TechnicalException;
import services.EntiteMigrationService;
import services.ReaderService;

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
