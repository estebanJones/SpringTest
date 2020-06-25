package fr.algorithmie;

import fr.boucles.ExerciceBoucleEtTests;

public class ComparaisonTableau {
	public static void main(String[] args) {
		int[] array1 = {1, 15, -3, 8, 7, 4, -2, 28, -1, 17, 2, 3, 0, 14, -4};
		int[] array2 = {3, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 8};
		
		ComparaisonTableau.nombreElementCommun(array1, array2);
	}
	
	
	
	public static void nombreElementCommun(int[] arrayOne, int[] arrayTwo) {
		// Si les tableau sont identiques en taille
		int tailleMax = arrayOne.length;
		// sinon il rentre dans la condition et prend le tableau le plus haut
		tailleMax = (arrayOne.length < arrayTwo.length) ? arrayTwo.length : arrayOne.length;
		// tableau qui contiendra les sommes
		int compteur = 0;
		
		for(int i = 0; i < tailleMax; i++) {
			// les conditions gèrent le OutOfBandException
			if(i > arrayOne.length - 1 || i > arrayTwo.length - 1) {
				continue;
			}
			else {
				if (arrayOne[i] == arrayTwo[i]) {
					compteur++;
				}
			}
			
		}
		// j'affiche le nouveau tableau avec les sommes
		System.out.println("compteur " + compteur);
	}
}
