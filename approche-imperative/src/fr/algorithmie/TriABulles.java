package fr.algorithmie;

import fr.boucles.ExerciceBoucleEtTests;

public class TriABulles {
	public static void main(String[] args) {
		int[] array = {3, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 8};
		TriABulles.triABulle(array);
		
	}
	
	public static void triABulle(int[] array) {
        int taille = array.length;  
        int tmp = 0;  
        for(int i=0; i < taille; i++) {
            for(int j=1; j < (taille-i); j++){  
                if(array[j-1] > array[j]){
                  //echanges des elements
                  tmp = array[j-1];  
                  array[j-1] = array[j];  
                  array[j] = tmp;  
                }
 
            }
        }
        ExerciceBoucleEtTests.afficherElement(array, "Resultat du trie a bulle");
	}
}
