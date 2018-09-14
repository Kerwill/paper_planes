package fr.sopra.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import fr.sopra.model.Categorie;
import fr.sopra.model.Etape;
import fr.sopra.model.Origami;
import fr.sopra.model.enumerateur.Niveau;

@Projection(name="origami", types={ Origami.class })
public interface OrigamiProjection {
	public int getId();
	public String getNom();
	public int getTemps();
	public int getFeuille();
	public int getNote();
	public boolean isDispo();
	public Set<Categorie> getCategories();
	public Set<Etape> getEtapes();
	public Niveau getNiveau();


}