package fr.algorithmie;

import java.util.Scanner;

public class InteractifChiffresSuivants {

	public static void main(String[] args) {
		InteractifChiffresSuivants.afficherLes10NombresSuivants();

	}
	
	public static void afficherLes10NombresSuivants() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ecrivez un nombre entre 1 et 10");
		String str = scan.nextLine();

		for (int i = 1; i <= 10; i++) {
			int valeur = Integer.parseInt(str) + i;
			System.out.println("valeur " + valeur);
		}
	
	}
}
