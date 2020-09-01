package fr.traitement.enums;

public enum TableEnum {
	CATEGORIE("Categorie"),
	PRODUIT("Produit"),
	INGREDIENT("Ingredient"),
	ALLERGENE("Allergene"),
	ADDITIF("Additif"),
	MARQUE("Marque");
	
	private String tableName;
	
	private TableEnum(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public String toString() {
		return tableName;
	}
	
}
