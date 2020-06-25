package fr.algorithmie;

import fr.boucles.ExerciceBoucleEtTests;

public class SommeDeTableau {

	public static void main(String[] args) {
		int[] arrayOne = { 1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4 };
		int[] arrayTwo = { -1, 12, 17, 14, 5, -9, 0, 18, -6, 0, 4, -13, 5, 7, -2, -8, -1};
		
		SommeDeTableau.sommeDeTableau(arrayOne, arrayTwo);
	
	}
	
	public static void sommeDeTableau(int[] arrayOne, int[] arrayTwo) {
		// Si les tableau sont identiques en taille
		int tailleMax = arrayOne.length;
		// sinon il rentre dans la condition et prend le tableau le plus haut
		tailleMax = (arrayOne.length < arrayTwo.length) ? arrayTwo.length : arrayOne.length;
		// tableau qui contiendra les sommes
		int[] tableauSomme = new int[tailleMax];
		
		for(int i = 0; i < tailleMax; i++) {
			// les conditions gèrent le OutOfBandException
			if(i > arrayOne.length - 1) {
				tableauSomme[i] = 0 + arrayTwo[i];
			}
			else if(i > arrayTwo.length - 1) {
				tableauSomme[i] = arrayOne[i] + 0;
			}
			else {
				tableauSomme[i] = arrayOne[i] + arrayTwo[i];
			}
			
		}
		// j'affiche le nouveau tableau avec les sommes
		ExerciceBoucleEtTests.afficherElement(tableauSomme, "Les sommes du nouveau tableau sont");
	}
}
