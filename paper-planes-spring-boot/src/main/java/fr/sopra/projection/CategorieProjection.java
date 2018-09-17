package fr.sopra.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import fr.sopra.model.Categorie;

@Projection(name="categorie", types={ Categorie.class })
public interface CategorieProjection {
	
		public int getId();
		public String getNom();
		public Set <Categorie> getCategories();


	}


