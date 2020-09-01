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
@Table(name="additif")
public class Additif {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", nullable=false, length=50)
	private String nom;
	
	@ManyToMany
	@JoinTable(name="compo_addi_prod", joinColumns=@JoinColumn(name="id_additif", referencedColumnName="id"),
									   inverseJoinColumns=@JoinColumn(name="id_produit", referencedColumnName="id")
	)
	private Set<Produit> produitsAdditifs;
	
	
	public Additif() {}
	
	public Additif(String nom) {
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

	public Set<Produit> getProduitsAdditifs() {
		return produitsAdditifs;
	}

	public void setProduitsAdditifs(Set<Produit> produitAdditifs) {
		this.produitsAdditifs = produitAdditifs;
	}

	@Override
	public String toString() {
		return "Additif [id=" + id + ", nom=" + nom + ", produitAdditifs=" + produitsAdditifs + "]";
	}
	
	
}
