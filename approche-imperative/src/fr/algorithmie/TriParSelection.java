package fr.algorithmie;

import fr.boucles.ExerciceBoucleEtTests;

public class TriParSelection {
	public static void main(String[] args) {
		int[] array2 = {3, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 8};
		TriParSelection.triSelection(array2);	
	}
	
    public static void triSelection(int[] array2) {
         for (int i = 0; i < array2.length - 1; i++){
		      int index = i;  
		      for (int j = i + 1; j < array2.length; j++) {
	             if (array2[j] < array2[index]){ 
	                index = j;
	             }
		      }
		      int min = array2[index];
		      array2[index] = array2[i]; 
		      array2[i] = min;
         }
         
         ExerciceBoucleEtTests.afficherElement(array2, "Resultat du trie par selection");
    }
}
