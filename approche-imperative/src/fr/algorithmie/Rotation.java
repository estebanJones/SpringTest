package fr.algorithmie;

public class Rotation {
	public static void main(String[] args) {
		int[] array = { 0, 3, 4, 0, 6, 7, 4, 4};
		Rotation.makeRotation(array);
		
	}
	
	public static void makeRotation(int[] array) {
		int tmp = array[array.length - 1];
		int tmp2 = array[0];
		
		for (int i = 0; i < array.length - 1; i++) {
			tmp2 = array[i];
			array[i] = tmp;
			tmp = tmp2;
			System.out.println("Le tableau est devenu " + array[i]);
		}
	}
}
