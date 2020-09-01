package fr.traitement.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.traitement.entities.Additif;
import fr.traitement.entities.Allergene;
import fr.traitement.entities.Categorie;
import fr.traitement.entities.Ingredient;
import fr.traitement.entities.Magasin;
import fr.traitement.entities.Marque;
import fr.traitement.entities.Nutriment;
import fr.traitement.entities.Produit;

public class FileDAO {
	ExctractFileDAO exctractFileRepo = ExctractFileDAO.getInstance();
	
	public FileDAO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Lis le fichier open-food-fact
	 * @return List<Magasin>
	 * @throws IOException
	 */
	public List<Magasin> lireOpenFoodFacts() throws IOException {
		return this.createResultatFileAggregate(exctractFileRepo.getFile());
	}
	
	
	/**
	 * Creer les objets brut à persister à partir du fichier
	 * @param reader
	 * @return List<Magasin>
	 * @throws IOException
	 */
	private List<Magasin> createResultatFileAggregate(List<String> lignes) throws IOException {
		List<Magasin> listMagasins = new ArrayList<>();
		
		int id = 1;
		lignes.remove(0);
		for(String line : lignes) {
			Categorie categorie = new Categorie(line.split("\\|", -1)[0]);
			Marque marque = new Marque(line.split("\\|", -1)[1]);
			Nutriment nutriment = new Nutriment(this.preventOutOfBoundsInteger(line, 5), 
												this.preventOutOfBoundsInteger(line, 6), 
												this.preventOutOfBoundsInteger(line, 7), 
												this.preventOutOfBoundsInteger(line, 8), 
												this.preventOutOfBoundsInteger(line, 9), 
												this.preventOutOfBoundsInteger(line, 10), 
												this.preventOutOfBoundsInteger(line, 11), 
												this.preventOutOfBoundsInteger(line, 12), 
												this.preventOutOfBoundsInteger(line, 13), 
												this.preventOutOfBoundsInteger(line, 14),
												this.preventOutOfBoundsInteger(line, 15), 
												this.preventOutOfBoundsInteger(line, 16), 
												this.preventOutOfBoundsInteger(line, 17), 
												this.preventOutOfBoundsInteger(line, 18), 
												this.preventOutOfBoundsInteger(line, 19), 
												this.preventOutOfBoundsInteger(line, 20), 
												this.preventOutOfBoundsInteger(line, 21), 
												this.preventOutOfBoundsInteger(line, 22),
												this.preventOutOfBoundsInteger(line, 23), 
												this.preventOutOfBoundsInteger(line, 24), 
												this.preventOutOfBoundsInteger(line, 25), 
												this.preventOutOfBoundsInteger(line, 26),
												(this.preventOutOfBoundsInteger(line, 27) == 0.0) ? false : true
										);
			Produit produit = new Produit(line.split("\\|", -1)[2]);
			produit.setMarque(marque);
			produit.setCategorie(categorie);
			produit.setNutriment(nutriment);
			
			Ingredient ingredient = new Ingredient(line.split("\\|", -1)[4]);
			Allergene allergene = new Allergene(this.preventOutOfBoundsString(line, 28));
			Additif additif = new Additif(this.preventOutOfBoundsString(line, 29));
			
			listMagasins.add(new Magasin(produit, ingredient, nutriment, allergene, additif));
		}
		return listMagasins;
	}
	

	private double preventOutOfBoundsInteger(String line, int index) {
		if(line.split("\\|", -1).length > index) {
			return this.checkDoubleLine(line.split("\\|", -1)[index]);
		} else {
			return 0.0;
		}
	}
	
	private String preventOutOfBoundsString(String line, int index) {
		if(line.split("\\|", -1).length > index) {
			return this.checkStringLine(line.split("\\|", -1)[index]);
		} else {
			return "Empty";
		}
	}
	/**
	 * Verifie si la ligne est vide ou si elle contient un espace
	 * Puis converti en double si necessaire
	 * @param str
	 * @return double
	 */
	private double checkDoubleLine(String str) {
		double value = 0.0;
		if(str.isBlank() || str.isEmpty()) {
			return value;
		} else if(this.estUnEntier(str)) {
			value = Double.parseDouble(str);
		}
		return value;
	}
	
	/**
	 * Verifie si la ligne est vide
	 * @param str
	 * @return
	 */
	private String checkStringLine(String str) {
		if(str.isBlank() || str.isEmpty()) {
			return "Empty";
		} else {
			return str;
		}
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
