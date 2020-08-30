package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", nullable=false, length=255)
	private String nom;
	
	@Embedded
	private Nutriment nutriment;
	
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="id_marque")
	private Marque marque;
	
	@ManyToMany(mappedBy="produitsAllergenes")
	private Set<Allergene> allergenes;
	
	@ManyToMany(mappedBy="produitsAdditifs")
	private Set<Additif> additifs;
	
	@ManyToMany(mappedBy="produitsIngredients")
	private Set<Ingredient> ingredients;
	
	public Produit() {
		
	}
	
	public Produit(String nom) {
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	
	public Nutriment getNutriment() {
		return nutriment;
	}

	public void setNutriment(Nutriment nutriment) {
		this.nutriment = nutriment;
	}
	
	
	public Set<Allergene> getAllergenes() {
		return allergenes;
	}

	public void setAllergenes(Set<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	public Set<Additif> getAdditifs() {
		return additifs;
	}

	public void setAdditifs(Set<Additif> additifs) {
		this.additifs = additifs;
	}
	
	
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", categorie=" + categorie + ", marque=" + marque + "]";
	}
	
	
}
