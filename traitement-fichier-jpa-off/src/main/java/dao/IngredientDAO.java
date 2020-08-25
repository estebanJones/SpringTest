package dao;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import database.ConnectionDatabase;
import entities.Ingredient;
import entities.Magasin;
import interfaces.migrationCRUD.ICRUDMirgration;
import transactiondb.Transaction;


public class IngredientDAO implements ICRUDMirgration {
	public IngredientDAO() {}
	
	
	@Override
	public void insertCSV(List<Magasin> mag, ConnectionDatabase connection) throws IOException {
		EntityManager manager = connection.initConnection();
		Transaction.startTransaction(manager);
		Set<Ingredient> ingredients = this.suppressionDoublon(mag);
		
		for(Ingredient i : ingredients) {
			System.out.println(i);
			//manager.persist(i);
		}

		Transaction.commitTransaction(manager);
		connection.closeConnection();
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
	public Set<Ingredient> formatteIngredient(List<Magasin> magasins) {
		Set<Ingredient> ingredients = new HashSet<>();
		
		magasins.stream()
				.map(el -> el.getIngredient().getNom().split("-|,|;"))
				.forEach(str -> {
					for(String s : str) {
						// Pour chaque Ingredient je remplace _, *, ) par ""
						s = s.replaceAll("_", "").replaceAll("\\*", "").replace(")", "").trim().toLowerCase();
						// Je garde que les Ingredients supérieur à 1 caractere
						if(s.length() > 1 && !s.isEmpty()) {
							int index = s.length() - 1;
							// si la fin de la chaine à un point, supprime le.
							if((char)s.charAt(index) == '.') {
								s = s.subSequence(0, index).toString();
							}
							// Retire toute la chaine après les deux points
							s = StringUtils.substringBefore(s, ":").trim();		
							// + veut dire 1 ou + occurence 
							// $ veut dire check jusqu'a la fin de la ligne
							// | veut dire Ou
							// ^ veut dire en debut de ligne
							//Cette regex retire les strings de forme e2467...etc
							s = s.replaceAll("e[0-9]+$|^e[0-9]+$", "");
							ingredients.add(new Ingredient(s));
						}
					}
				});
		return ingredients;
	}
	
}
