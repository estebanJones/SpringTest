package fr.boucles;

public class ExerciceBoucleEtTests {
	public static void main(String[] args) {
		// Tableau
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		// Afficher l'ensemble des éléments du tableau grâce à une boucle
		ExerciceBoucleEtTests.afficherElement(array, "Voici les elements");
		// Afficher l'ensemble des éléments dans l'ordre inverse du tableau
		ExerciceBoucleEtTests.reverseArray(array);
		// Combiner une boucle et un test de manière à n'afficher que les entiers supérieurs à 3
		ExerciceBoucleEtTests.afficherElementSuperieur3(array);
		// Combiner une boucle et un test de manière à n'afficher que les entiers pairs
		ExerciceBoucleEtTests.afficherEntiersPairs(array);
		// Combiner une boucle et un test de manière à n'afficher que les valeurs des index pairs
		ExerciceBoucleEtTests.afficherElementsIndexPairs(array);
		// Combiner une boucle et un test de manière à n'afficher que les entiers impairs
		ExerciceBoucleEtTests.afficherEntiersImpairs(array);
	}
	
	public static void afficherElement(int[] array, String phrase) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(phrase + " " + array[i]);
		}
	}
	
	public static void reverseArray(int[] array) {
		for(int i =  array.length - 1; i >= 0; i--) {
			System.out.println("element de array inversés " + array[i]);
		}
	}
	
	public static void afficherElementSuperieur3(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] <= 3) {
				continue;
			}
			System.out.println("element supérieur à 3 " + array[i]);
		}
	}
	
	public static void afficherEntiersPairs(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if ((array[i] % 2) != 0)  {
				continue;
			}
			System.out.println("element entiers pairs " + array[i]);
		}
	}
	
	public static void afficherElementsIndexPairs(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if ((i % 2) != 0)  {
				continue;
			}
			
			System.out.println("element index paire index: " + i + " valeur " + array[i]);
		}
	}
	
	public static void afficherEntiersImpairs(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if ((array[i] % 2) == 0)  {
				continue;
			}
			
			System.out.println("element entier impairs " + array[i]);
		}
	}
}

