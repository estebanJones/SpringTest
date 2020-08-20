package repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import entities.Categorie;
import entities.Ingredient;
import entities.Magasin;
import entities.Marque;
import entities.Nutriment;
import entities.Produit;


public class ExctractFileRepo {
	private static ExctractFileRepo INSTANCE;
	private static final String PATH = "./file/openFoodFacts.csv";

	private ExctractFileRepo() {}
	
	/**
	 * Singleton de ExtractFileRepo
	 * @return
	 */
	public static ExctractFileRepo getInstance() {
		if(ExctractFileRepo.INSTANCE == null) {
			ExctractFileRepo.INSTANCE = new ExctractFileRepo();
		}
		return ExctractFileRepo.INSTANCE;
	}
	
	/**
	 * Lis le fichier open-food-fact
	 * @return List<Magasin>
	 * @throws IOException
	 */
	public List<Magasin> lireOpenFoodFacts() throws IOException {
		return this.createResultatFileAggregate(this.getFile());
	}
	
	/**
	 * Recupere le fichier pour le lire
	 * @return BufferedReader
	 * @throws IOException
	 */
	private List<String> getFile() throws IOException {
		File file = new File(ExctractFileRepo.PATH);
		return FileUtils.readLines(file, "UTF-8");
	}
	
	/**
	 * Creer les objets à persister à partir du fichier
	 * @param reader
	 * @return List<Magasin>
	 * @throws IOException
	 */
	private List<Magasin> createResultatFileAggregate(List<String> lignes) throws IOException {
		List<Magasin> listFichier = new ArrayList<>();
		
		int id = 1;
		// Index 5 out of bounds for length 5
		lignes.remove(0);
		for(String line : lignes) {
			Categorie categorie = new Categorie(id, line.split("\\|", -1)[0]);
			Marque marque = new Marque(line.split("\\|", -1)[1]);
			Nutriment nutriment = new Nutriment(this.preventOutOfBounds(line, 5), 
												this.preventOutOfBounds(line, 6), 
												this.preventOutOfBounds(line, 7), 
												this.preventOutOfBounds(line, 8), 
												this.preventOutOfBounds(line, 9), 
												this.preventOutOfBounds(line, 10), 
												this.preventOutOfBounds(line, 11), 
												this.preventOutOfBounds(line, 12), 
												this.preventOutOfBounds(line, 13), 
												this.preventOutOfBounds(line, 14),
												this.preventOutOfBounds(line, 15), 
												this.preventOutOfBounds(line, 16), 
												this.preventOutOfBounds(line, 17), 
												this.preventOutOfBounds(line, 18), 
												this.preventOutOfBounds(line, 19), 
												this.preventOutOfBounds(line, 20), 
												this.preventOutOfBounds(line, 21), 
												this.preventOutOfBounds(line, 22),
												this.preventOutOfBounds(line, 23), 
												this.preventOutOfBounds(line, 24), 
												this.preventOutOfBounds(line, 25), 
												this.preventOutOfBounds(line, 26),
												this.preventOutOfBounds(line, 27)
										);
			Produit produit = new Produit(line.split("\\|", -1)[2]);
			produit.setMarque(marque);
			produit.setCategorie(categorie);
			Ingredient ingredient = new Ingredient(id, line.split("\\|", -1)[4]);
			id++;
			listFichier.add(new Magasin(produit, ingredient, nutriment));
			
		}
		return listFichier;
	}
	
	private double preventOutOfBounds(String line, int index) {
		if(line.split("\\|", -1).length > index) {
			return this.checkLine(line.split("\\|", -1)[index]);
		} else {
			return 0.0;
		}
	}
	/**
	 * Verifie si la ligne est vide ou si elle contient un espace
	 * Puis converti en double si necessaire
	 * @param str
	 * @return double
	 */
	private double checkLine(String str) {
		double value = 0.0;
		if(str.isBlank() || str.isEmpty()) {
			return value;
		} else if(this.estUnEntier(str)) {
			value = Double.parseDouble(str);
		}
		return value;
	}
	
	/**
	 * Verifie si la String peut être converti en double
	 * @param chaine
	 * @return boolean
	 */
	private boolean estUnEntier(String chaine) {
		
        try {
            Integer.parseInt(chaine);
        } catch (NumberFormatException e){
            return false;
        }
 
        return true;
    }
	
	
}
