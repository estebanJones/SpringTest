package controller;

import java.io.IOException;
import java.util.List;

import database.ManagerConnection;
import entities.Magasin;
import services.EntiteMigrationService;
import services.ReaderService;

public class IntegrationOpenFoodFacts {
	public static void main(String[] args) {
		ReaderService readerService = new ReaderService();
		EntiteMigrationService entiteMigrationService = EntiteMigrationService.getInstance();
		ManagerConnection connection = new ManagerConnection();
		List<Magasin> mag;
		
		try {
			mag = readerService.readFile();
			entiteMigrationService.persistEntities(mag, connection);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		entiteMigrationService.close();
	}
}
