package fr.algorithmie;

import java.util.Scanner;

public class InteractifStockageNombre {

	public static void main(String[] args) {
		InteractifStockageNombre.test();

	}
	
	public static void test() {
		InteractifStockageNombre.showOptions();
		Scanner scan = new Scanner(System.in);
		int str = scan.nextInt();
		int[] tableau = new int[1];
		int[] array = new int[0];
		int index = 0;
		
		while(!String.valueOf(str).equalsIgnoreCase("X")) {
			InteractifStockageNombre.showOptions();
			scan = new Scanner(System.in);
			
			if(str == 1) {
				System.out.println("Ajouter un nombre");
				scan = new Scanner(System.in);
				if(index >= tableau.length) {
					array = new int[index + 1];
					array[index] = tableau[0];
				
				} else {
					tableau[index] = str;
				}
				index++;					
			} 
			else if (str == 2) {
				System.out.println("Voici les nombres rentrés");
				for(int i = 0; i < array.length; i++) {
					System.out.print(array[i] + " ");
				}
			}
			str = scan.nextInt();
		}
		
	}
	
	private static void showOptions() {
		System.out.println("Choisir une option :");
		System.out.println("Apuuyer sur 1 -> Ajouter un nombre !");
		System.out.println("Apuuyer sur 2 -> Afficher les nombres existants !");
		System.out.println("Apuuyer sur X -> Quitter");
	}
}
