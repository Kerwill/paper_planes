package fr.sopra.projection;


import org.springframework.data.rest.core.config.Projection;

import fr.sopra.model.Idee;


@Projection(name="idee", types={ Idee.class })
public interface IdeeProjection {
	public int getId();
	public String getNom();
	public String getPrenom();
	public String getMail();
	public String getDescription();

}