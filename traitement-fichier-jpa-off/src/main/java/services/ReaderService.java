package services;

import java.io.IOException;
import java.util.List;

import dao.FileDAO;
import entities.Magasin;

public class ReaderService {
	FileDAO fileDAO;
	
	public ReaderService() {
		 this.fileDAO = new FileDAO();
	}
	
	public List<Magasin> readFile() throws IOException {
		return this.fileDAO.lireOpenFoodFacts();
	}
}
