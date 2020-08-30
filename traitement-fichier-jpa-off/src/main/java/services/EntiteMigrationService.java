package services;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.AdditifDAO;
import dao.CategorieDAO;
import dao.FileDAO;
import dao.IngredientDAO;
import dao.MarqueDAO;
import dao.ProduitDAO;
import database.ManagerConnection;
import entities.Magasin;

public class EntiteMigrationService {
	private MarqueDAO marqueDAO;
	private ProduitDAO produitDAO;
	private CategorieDAO categorieDAO;
	private IngredientDAO ingredientDAO;
	private AdditifDAO additifDAO;
	
	private EntityManager connection;
	
	private EntiteMigrationService() {
		connection = ManagerConnection.initConnection();
		this.marqueDAO = new MarqueDAO();
		this.produitDAO = new ProduitDAO();
		this.categorieDAO = new CategorieDAO();
		this.ingredientDAO = new IngredientDAO();
		this.additifDAO = new AdditifDAO();
	}
	
	public static EntiteMigrationService getInstance() {
		return new EntiteMigrationService();
	}
	
	/**
	 * Insert les differentes entités du fichier en base
	 * @param mag
	 * @param connection
	 * @throws IOException
	 */
	public void persistEntities(List<Magasin> mag, ManagerConnection connection) throws IOException {
//		this.marqueDAO.insertCSV(mag, connection);
//		this.categorieDAO.insertCSV(mag, connection);
		this.ingredientDAO.insertCSV(mag, connection);
//		this.additifDAO.insertCSV(mag, connection);
//		this.produitDAO.insertCSV(mag, connection);
	}
	
	/**
	 * Ferme le pipe avec la base de donnée
	 */
	public void close() {
		connection.close();
	}
}
