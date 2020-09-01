package fr.traitement.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", nullable=false, length=1000)
	private String nom;
	
	@ManyToMany
	@JoinTable(name="compo_ingre_prod", joinColumns=@JoinColumn(name="id_ingredient", referencedColumnName="id"),
										inverseJoinColumns=@JoinColumn(name="id_produit", referencedColumnName="id")
				)
	Set<Produit> produitsIngredients;
	
	
	public Ingredient() {}
	
	public Ingredient(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public Set<Produit> getProduitsIngredients() {
		return produitsIngredients;
	}

	public void setProduitsIngredients(Set<Produit> produitsIngredients) {
		this.produitsIngredients = produitsIngredients;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
