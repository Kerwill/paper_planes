package fr.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "etape")

public class Etape {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ETA_ID")
	private int id;

	@Column(name = "ETA_DESCRIPTIF", columnDefinition = "TEXT", nullable = false)
	@NotEmpty
	private String descriptif;

	@Column(name = "ETA_IMAGE")
	@Size(max = 500)
	private String image;

	@Column(name = "ETA_VIDEO")
	@Size(max = 500)
	private String video;

	@Column(name = "ETA_ORDRE", nullable = false)
	@Positive
	private int ordre;

	@ManyToOne
	@JoinColumn (name="ETA_ORIGAMI_ID")
	private Origami origami;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Origami getOrigami() {
		return origami;
	}

	public void setOrigami(Origami origami) {
		this.origami = origami;
	}

	
}
