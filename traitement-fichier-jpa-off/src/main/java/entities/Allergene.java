package entities;

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
@Table(name="allergene")
public class Allergene {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", length=50, nullable=false)
	private String nom;
	
	@ManyToMany
	@JoinTable(name="compo_allerg_prod", joinColumns=@JoinColumn(name="id_allergene", referencedColumnName="id"),
										 inverseJoinColumns=@JoinColumn(name="id_produit", referencedColumnName="id")
	)
	private Set<Produit> produitsAllergenes;
	
	public Allergene() {}
	
	public Allergene(String nom) {
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

	public Set<Produit> getProduitsAllergenes() {
		return produitsAllergenes;
	}

	public void setProduitsAllergenes(Set<Produit> produitsAllergenes) {
		this.produitsAllergenes = produitsAllergenes;
	}

	@Override
	public String toString() {
		return "Allergene [id=" + id + ", nom=" + nom + ", produitsAllergenes=" + produitsAllergenes + "]";
	}
	
	
	
}
