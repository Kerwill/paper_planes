package fr.sopra.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import fr.sopra.model.enumerateur.Niveau;

@Entity
@Table(name = "origami")
public class Origami {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORI_ID")
	private int id;

	@Column(name = "ORI_NOM", length = (100), nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String nom;

	@Column(name = "ORI_TEMPS", nullable = false, columnDefinition = "INT DEFAULT 1")
	@Positive
	private int temps;

	@Column(name = "ORI_FEUILLE", nullable = false, columnDefinition = "INT DEFAULT 1")
	@Positive
	private int feuille;

	@Column(name = "ORI_NOTE", nullable = false, columnDefinition = "INT DEFAULT 1")
	@Positive
	private int note;

	@Column(name = "ORI_DISPO", nullable = false)
	private boolean dispo;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ORI_NIVEAU", nullable = false)
	private Niveau niveau;

	@OneToMany(mappedBy = "origami")
	private Set<Etape> etapes;

	@ManyToMany(mappedBy = "origamis")
	private Set<Categorie> categories;

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

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public int getFeuille() {
		return feuille;
	}

	public void setFeuille(int feuille) {
		this.feuille = feuille;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public Set<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(Set<Etape> etapes) {
		this.etapes = etapes;
	}

	public Set<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

}