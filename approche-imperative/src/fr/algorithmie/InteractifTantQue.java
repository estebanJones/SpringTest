package fr.algorithmie;

import java.util.Scanner;

public class InteractifTantQue {
	public static void main(String[] args ) {
		InteractifTantQue.calculerUneTable();
		
		
	}
	
	public static void calculerUneTable() {
		int result = 0;
		int i = 0;
		int valeur = 0;
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Ecrivez un nombre entre 1 et 10");
			String str = scan.nextLine();
			valeur = Integer.parseInt(str);
		}while(valeur < 1 || valeur > 10);
		
		// si le nombre est de 0 il n'a pas était modifier donc la valeur rentrer n'est pas comprise entre 1 et 10
		if(valeur != 0) {
			System.out.println("valeur " + valeur);
		}
	}
}
