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
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
@NamedNativeQuery(name= "getAllCategoriesByOrigamiId", query="SELECT c.nom FROM categorie c, origami o, branche b"+
		"LEFT JOIN c.cat_id on b.bra_categorie_id" +
		"WHERE o.ori_id = b.bra_origami_id")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAT_ID")
	private int id;

	@Column(name = "CAT_NOM")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="CAT_PARENT", referencedColumnName = "CAT_ID")
	private Categorie parent; 

	@ManyToMany
	@JoinTable(
			name="branche",
			uniqueConstraints=@UniqueConstraint(columnNames = { "BRA_CATEGORIE_ID", "BRA_ORIGAMI_ID" }),
			joinColumns=@JoinColumn(name="BRA_CATEGORIE_ID", referencedColumnName="CAT_ID"),
			inverseJoinColumns=@JoinColumn(name="BRA_ORIGAMI_ID", referencedColumnName="ORI_ID"))
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

	public Categorie getParent() {
		return parent;
	}

	public void setParent(Categorie parent) {
		this.parent = parent;
	}
	
	
	

}
