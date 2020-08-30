package database;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entities.Categorie;
import entities.Marque;
import entities.Produit;

public class ManagerLinkProduit {
	
	
	
	public static Set<Produit> produitLinked(List<Object> resultatRequeteMarque, List<Object> resultatRequeteCategorie, Set<Produit> produits) {
		Set<Produit> produitCategorieLinked = ManagerLinkProduit.linkProduitCategorie(resultatRequeteCategorie, produits);
		return ManagerLinkProduit.linkProduitMarque(resultatRequeteMarque, produitCategorieLinked);
	}
	
	public static Set<Produit> linkProduitMarque(List<Object> resultatRequeteMarque, Set<Produit> produits) {
		Set<Produit> marqueProduitLinked = new HashSet<>();
		
		for(Produit p : produits) {
			resultatRequeteMarque.forEach(e -> {
				Marque marque = (Marque) e;
				if(marque.getNom().equalsIgnoreCase(p.getMarque().getNom())) {
					p.setCategorie(p.getCategorie());
					p.setMarque(marque);

					marqueProduitLinked.add(p);
				}
			});
		}
		return marqueProduitLinked;
	}
	
	public static Set<Produit> linkProduitCategorie(List<Object> resultatRequeteCategorie, Set<Produit> produits) {
		Set<Produit> categorieProduitLinked = new HashSet<>();
		
		for(Produit p : produits) {
			resultatRequeteCategorie.forEach(e -> {
				Categorie categorie = (Categorie) e;
				if(categorie.getNom().equalsIgnoreCase(p.getCategorie().getNom())) {
					p.setCategorie(categorie);
					categorieProduitLinked.add(p);
				}
				
			});
		}
		return categorieProduitLinked;
	}
}
