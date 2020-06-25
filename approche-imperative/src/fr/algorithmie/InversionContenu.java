package fr.algorithmie;

import java.util.Arrays;
import java.util.Collections;

import fr.boucles.ExerciceBoucleEtTests;

public class InversionContenu {

	public static void main(String[] args) {
		int[] array = { 1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4 };
		InversionContenu.copieArrayAndReverse(array);
		
	}
	

	public static void copieArrayAndReverse(int[] array) {
		int[] copieInversed = new int[array.length];
		int indexCopy = 0;
		
		// recréer un tableau inversé
		for(int i =  array.length - 1; i >= 0; i--) {
			copieInversed[indexCopy] = array[i];
			indexCopy++;
		}
		// affiche le tableau initial
		ExerciceBoucleEtTests.afficherElement(array, "Voici le tableau initial");
		System.out.println("-------------------------------------------------------------");
		// affiche le tableau initial copié et inversé
		ExerciceBoucleEtTests.afficherElement(copieInversed, "Voici le tableau inversé");
	}

}
