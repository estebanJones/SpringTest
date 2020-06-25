package fr.boucles;

public class ExerciceTableauEntier {
	public static void main(String[] args) {
		// Déclarez un tableau d'entiers contenant tous les entiers de 1 à 10
		int[] tableauInt = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// Affichez le premier élément du tableau
		ExerciceTableauEntier.premierElementTableau(tableauInt);
		// Affichez la longueur du tableau en utilisant la propriété length
		ExerciceTableauEntier.longueurDeTableau(tableauInt);
		// Affichez le dernier élément du tableau en utilisant la propriété length
		ExerciceTableauEntier.showLastElement(tableauInt);
		// Modifiez la valeur de l'élément d'index 4 et donnez lui la valeur 8
		ExerciceTableauEntier.modifierIndex(tableauInt, 4, 8);
	}
	
	public static void premierElementTableau(int[] tableau) {
		System.out.println("premier element du tableau " + tableau[0]);
	}
	
	public static void longueurDeTableau(int[] tableau) {
		System.out.println("La longueur du tableau est " + tableau.length);
	}
	
	public static void showLastElement(int[] tableau) {
		int dernierIndex = tableau.length - 1;
		System.out.println("le dernier element du tableau est " + tableau[dernierIndex]);
	}
	
	public static void modifierIndex(int[] tableau, int index, int valeur) {
		tableau[index] = valeur;
		for(int i = 0; i < tableau.length; i++) {
			System.out.println("elements du tableau " + tableau[i]);
		}
	}
}
