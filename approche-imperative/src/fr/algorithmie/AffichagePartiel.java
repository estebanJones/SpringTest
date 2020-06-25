package fr.algorithmie;

import fr.boucles.ExerciceBoucleEtTests;

public class AffichagePartiel {
	public static void main(String[] args) {
		int[] array = { 1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4 };
		
		// Combiner une boucle et un test de manière à n'afficher que les entiers supérieurs à 3
		ExerciceBoucleEtTests.afficherElementSuperieur3(array);
		// Combiner une boucle et un test de manière à n'afficher que les entiers pairs
		ExerciceBoucleEtTests.afficherEntiersPairs(array);
		// Combiner une boucle et un test de manière à n'afficher que les valeurs des index pairs
		ExerciceBoucleEtTests.afficherElementsIndexPairs(array);
		// Combiner une boucle et un test de manière à n'afficher que les entiers impairs
		ExerciceBoucleEtTests.afficherEntiersImpairs(array);
	}
}
