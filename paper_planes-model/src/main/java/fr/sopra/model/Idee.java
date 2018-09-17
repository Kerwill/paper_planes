package fr.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "idee")
public class Idee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDE_ID")
	private int id;

	@Column(name = "IDE_NOM", length = (100), nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String nom;

	@Column(name = "IDE_PRENOM", length = (100), nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String prenom;

	@Column(name = "IDE_MAIL", length = (200), nullable = false)
	@NotEmpty
	@Size(max = 200)
	private String mail;

	@Column(name = "IDE_DESCRIPTION", length = (1200), nullable = false)
	@NotEmpty
	@Size(max = 1200)
	private String description;

	@Column(name = "IDE_IS_ARCHIVE", nullable = true)
	private boolean isArchive;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isArchive() {
		return isArchive;
	}

	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}


	
	
}