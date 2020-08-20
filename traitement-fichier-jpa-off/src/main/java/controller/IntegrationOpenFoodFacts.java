package controller;

import java.io.IOException;
import java.util.List;

import dao.MarqueDAO;
import dao.ProduitDAO;
import database.ConnectionDatabase;
import entities.Magasin;
import repositories.ExctractFileRepo;

public class IntegrationOpenFoodFacts {
	public static void main(String[] args) {
		MarqueDAO marqueDAO = new MarqueDAO();
		ProduitDAO produitDAO = new ProduitDAO();
		ExctractFileRepo exctractFileRepo = ExctractFileRepo.getInstance();
		ConnectionDatabase connection = new ConnectionDatabase();
		try {
			List<Magasin> mag = exctractFileRepo.lireOpenFoodFacts();
			//marqueDAO.insertCSV(mag, connection);
			produitDAO.insertCSV(mag, connection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
