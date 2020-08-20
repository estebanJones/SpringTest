package entities;

public class Magasin {
	private Produit produit;
	private Ingredient ingredient;
	private Nutriment nutriment;
	
	public Magasin(Produit produit, Ingredient ingredient, Nutriment nutriment) {
		this.produit = produit;
		this.ingredient = ingredient;
		this.nutriment = nutriment;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}


	public Nutriment getNutriment() {
		return nutriment;
	}

	public void setNutriment(Nutriment nutriment) {
		this.nutriment = nutriment;
	}

	@Override
	public String toString() {
		return "Magasin [produit=" + produit + " , ingredient=" + ingredient + " + ]";
	}
	
	
}
