package fr.algorithmie;

public class FirstLast {

	public static void main(String[] args) {
		int[] array = {6, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 6};
		FirstLast.checkFirstLast(array);
	}
	
	public static boolean checkFirstLast(int[] array) {
		boolean validator = false;
		for(int i = 0; i < array.length; i++) {
			validator = (array.length >= 1 && array[0] == array[array.length - 1]) ? true : false;
		}
		System.out.println("validator " + validator);
		return validator;
	}
}
