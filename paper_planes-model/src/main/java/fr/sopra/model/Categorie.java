package fr.sopra.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CAT_ID")
	private int id;

    @Column(name="CAT_NOM")
    private String nom;

	@ManyToMany
	@JoinTable(
			name="origami",
			uniqueConstraints=@UniqueConstraint(columnNames = { "CMD_CATEGORIE_ID", "CMD_ORIGAMI_ID" }),
			joinColumns=@JoinColumn(name="CMD_CATEGORIE_ID", referencedColumnName="CAT_ID"),
			inverseJoinColumns=@JoinColumn(name="CMD_ORIGAMI_ID", referencedColumnName="ORI_ID"))
	private Set<Origami> origamis;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
  public Set<Origami> getOrigamis() {
    return origamis;
  }
  public void setOrigamis(Set<Origami> origamis) {
    this.origamis = origamis;
  }
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}



}
