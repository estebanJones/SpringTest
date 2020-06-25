package fr.boucles;

public class ExerciceBoucleBase {
	public static void main(String[] args) {
		// Afficher tout les nombres de 1 à 10
		ExerciceBoucleBase.jusqua10();
		// Affichez 20 fois votre nom et prenom
		ExerciceBoucleBase.jusqua20("Jordan", "Teixeira");
		// Affichez les éléments pairs de 2 à 100
		ExerciceBoucleBase.elementPairs();
		// Affichez les éléments impars de 1 à 99
		ExerciceBoucleBase.elementImpairs();
	}
	
	public static void jusqua10() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("valeur de i = " + i);
		}
	}
		
	public static void jusqua20(String prenom, String nom) {
		for(int i = 1; i <= 20; i++) {
			System.out.println("Votre prenom est " + prenom + " et votre nom " + nom);
		}
	}

	public static void elementPairs() {
		for(int i = 2; i <= 100; i+=2) {
			System.out.println("Les nombres pairs de 2 à 100 sont " + i);
		}
	}

	public static void elementImpairs() {
		for(int i = 1; i < 101; i+=2) {
			System.out.println("Les nombres impairs de 0 à 100 sont " + i);
		}
	}
}
