package controller;

import java.io.IOException;
import java.util.List;

import dao.AdditifDAO;
import dao.CategorieDAO;
import dao.FileDAO;
import dao.IngredientDAO;
import dao.MarqueDAO;
import dao.ProduitDAO;
import database.ConnectionDatabase;
import entities.Magasin;

public class IntegrationOpenFoodFacts {
	public static void main(String[] args) {
		MarqueDAO marqueDAO = new MarqueDAO();
		ProduitDAO produitDAO = new ProduitDAO();
		CategorieDAO categorieDAO = new CategorieDAO();
		IngredientDAO ingredientDAO = new IngredientDAO();
		AdditifDAO additifDAO = new AdditifDAO();
		
		FileDAO fileDAO = new FileDAO();
		ConnectionDatabase connection = new ConnectionDatabase();
		
		try {
			List<Magasin> mag = fileDAO.lireOpenFoodFacts();
			//marqueDAO.insertCSV(mag, connection);
			//categorieDAO.insertCSV(mag, connection);
			//produitDAO.insertCSV(mag, connection);
			ingredientDAO.insertCSV(mag, connection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
