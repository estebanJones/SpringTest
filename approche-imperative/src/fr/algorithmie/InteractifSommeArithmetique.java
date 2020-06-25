package fr.algorithmie;

import java.util.Scanner;

public class InteractifSommeArithmetique {
	public static void main(String[] args) {
		InteractifSommeArithmetique.afficherSommeArithmetique();
	}
	
	
	public static void afficherSommeArithmetique() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ecrivez un nombre entre 1 et 10");
		String str = scan.nextLine();
		int somme = 1;
		for (int i = 1; i < Integer.parseInt(str); i++) {
			if (Integer.parseInt(str) >= 1) {
				somme = somme + (i + 1);
			}
			
		}
		System.out.println("somme " + somme);
	
	}
}
