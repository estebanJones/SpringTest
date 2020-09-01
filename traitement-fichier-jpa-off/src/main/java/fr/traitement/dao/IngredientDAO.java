package fr.traitement.dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import fr.traitement.database.ManagerConnection;
import fr.traitement.entities.Ingredient;
import fr.traitement.entities.Magasin;
import fr.traitement.interfaces.migrationCrud.ICRUDMirgration;
import fr.traitement.transactiondb.Transaction;
import fr.traitement.utils.StringFormatter;


public class IngredientDAO implements ICRUDMirgration {
	public IngredientDAO() {}
	
	
	@Override
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException {
		EntityManager manager = ManagerConnection.initConnection();
		Transaction.startTransaction(manager);
		Set<Ingredient> ingredients = this.suppressionDoublon(mag);
		
		for(Ingredient i : ingredients) {
			//System.out.println(i);
			manager.persist(i);
		}
		Transaction.commitTransaction(manager);
	}
	
	/**
	 * Supprime les doublons en prenant en compte les accents
	 * @param List<Magasin> magasins
	 * @return Set<Marque>
	 */
	public Set<Ingredient> suppressionDoublon(List<Magasin> magasins) {
		Set<Ingredient> ingredients = this.formatteIngredient(magasins);
		return ingredients.stream()
				          .map(e -> new Ingredient(e.getNom()))
				          .distinct()
				          .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Ingredient::getNom))));
	}
	
	/**
	 * 
	 * @param magasins
	 * @return
	 */
	public Set<Ingredient> formatteIngredient(List<Magasin> magasins) {
		Set<Ingredient> ingredients = new HashSet<>();
		
		magasins.stream()
				.map(el -> el.getIngredient().getNom().split("-|,|;"))
				.forEach(str -> {

					for(String ingredientName : str) {
						ingredientName = this.clearIngredientName(ingredientName);
						
						if(ingredientName.length() > 1 && !ingredientName.isEmpty()) {
							StringFormatter.supprimePointFinal(ingredientName);
							ingredientName = StringUtils.substringBefore(ingredientName, ":").trim();		
							//Cette regex retire les strings de forme e2467...etc
							ingredientName = ingredientName.replaceAll("e[0-9]+$|^e[0-9]+$", "");
							
							if (!this.deleteStringFromInt(ingredientName).isBlank()) {
								ingredients.add(new Ingredient(this.deleteStringFromInt(ingredientName)));
							}	
						}
					}
				});
		return ingredients;
	}
	
	/**
	 * Nettoie le nom des ingrédients
	 * @param ingredientName
	 * @return
	 */
	public String clearIngredientName(String ingredientName) {
		ingredientName = StringFormatter.supprimerCrochet(ingredientName);
		ingredientName = StringFormatter.supprimerParentheses(ingredientName);
		ingredientName = StringFormatter.supprimerPointInterrogation(ingredientName);
		ingredientName = StringFormatter.supprimerSpecialChars(ingredientName);
		
		return ingredientName;
	}
	
	/**
	 * Supprime un morceau de la chaine à partir du premier nombre qu'il rencontre
	 * @param chaine
	 * @return
	 */
	public String deleteStringFromInt(String chaine) {
		int index = this.estUnEntier(chaine, chaine.length());
		String newChaine = "";
		if(index != -1 && index != 0) {
			newChaine = chaine.subSequence(0, index - 1).toString();

		}
		return newChaine;
	}
	
	/**
	 * Check si la lettre est un entier 
	 * @param chaine
	 * @param chaineLength
	 * @return
	 */
	public int estUnEntier(String chaine, int chaineLength) {
		String[] tab = chaine.split("");
		int suppressFromIndex = 0;
		if(tab.length > 1) {
			for(int i=0; i < tab.length; i++) {
				try {
					if(Character.isDigit((char)chaine.charAt(i))) {
						suppressFromIndex = i;
						break;
					}
				} catch (NumberFormatException e){
					return -1;
				}
			}
		}
		return suppressFromIndex;
    }
	
}
