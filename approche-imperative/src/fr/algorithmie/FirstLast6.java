package fr.algorithmie;

public class FirstLast6 {

	public static void main(String[] args) {
		int[] array = {0, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 6};
		FirstLast6.checkFirstLast6(array);
	}
	
	public static boolean checkFirstLast6(int[] array) {
		boolean validator = false;
		for(int i = 0; i < array.length; i++) {
			validator = (array.length >= 1 && array[0] == 6 || array[array.length - 1] == 6) ? true : false;
		}
		System.out.println("validator " + validator);
		return validator;
	}

}
