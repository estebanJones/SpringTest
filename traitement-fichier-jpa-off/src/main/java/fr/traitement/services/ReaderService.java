package fr.traitement.services;

import java.io.IOException;
import java.util.List;

import fr.traitement.dao.FileDAO;
import fr.traitement.entities.Magasin;

public class ReaderService {
	FileDAO fileDAO;
	
	public ReaderService() {
		 this.fileDAO = new FileDAO();
	}
	
	public List<Magasin> readFile() throws IOException {
		return this.fileDAO.lireOpenFoodFacts();
	}
}
