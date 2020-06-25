package fr.algorithmie;

import java.util.Scanner;

public class InteractifPlusGrand {

	public static void main(String[] args) {
		InteractifPlusGrand.lePlusGrand();

	}
	
	public static void lePlusGrand() {
		int nombreIteration = 0;
		int[] tableau = new int[10];
	
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Ecriver 10 chiffres");
			String str = scan.nextLine();
			tableau[nombreIteration] = Integer.parseInt(str);
			nombreIteration++;
		}while(nombreIteration < 10);
		
		
		System.out.println("le plus grand nombre est " + RechercheMax.rechercheMax(tableau));;
	}

}
