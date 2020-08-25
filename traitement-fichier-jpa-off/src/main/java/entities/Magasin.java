package entities;

public class Magasin {
	private Produit produit;
	private Ingredient ingredient;
	private Nutriment nutriment;
	private Allergene allergene;
	private Additif additif;
	
	public Magasin(Produit produit, Ingredient ingredient, Nutriment nutriment, Allergene allergene, Additif additif) {
		this.produit = produit;
		this.ingredient = ingredient;
		this.nutriment = nutriment;
		this.allergene = allergene;
		this.additif = additif;
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
	
	public Allergene getAllergene() {
		return allergene;
	}

	public void setAllergene(Allergene allergene) {
		this.allergene = allergene;
	}

	public Additif getAdditif() {
		return additif;
	}

	public void setAdditif(Additif additif) {
		this.additif = additif;
	}

	@Override
	public String toString() {
		return "Magasin [produit=" + produit + " , ingredient=" + ingredient + " + ]";
	}
	
	
}
