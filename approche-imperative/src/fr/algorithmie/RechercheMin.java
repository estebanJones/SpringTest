package fr.algorithmie;

public class RechercheMin {
	public static void main(String[] args) {
		int[] array = { 1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4 };
		RechercheMin.rechercheMin(array);
	}
	
	public static int rechercheMin(int[] array) {
		int valeurMinimum = RechercheMax.rechercheMax(array);
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] < valeurMinimum) {
				valeurMinimum = array[i];
			}
		}
		System.out.println("valeur minimum " + valeurMinimum);
		return valeurMinimum;
	}
}
