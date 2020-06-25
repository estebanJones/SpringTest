package fr.algorithmie;

import java.util.Scanner;

public class InteractifTableMult {
	public static void main(String[] args) {
		InteractifTableMult.calculerUneTable();
		
	}
	
	public static void calculerUneTable() {
		int result = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ecrivez un nombre entre 1 et 10");
		String str = scan.nextLine();
		
		for (int i = 0; i <= 10; i++) {
			result = Integer.parseInt(str) * i;
			System.out.println( str + "x" + i + "=" + result);
		}
	}
}
