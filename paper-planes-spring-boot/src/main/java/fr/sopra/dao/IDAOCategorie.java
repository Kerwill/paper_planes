package fr.sopra.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Categorie;
import fr.sopra.model.Origami;
import fr.sopra.projection.CategorieProjection;
import fr.sopra.projection.OrigamiProjection;
@CrossOrigin("*")
@RepositoryRestResource(excerptProjection = CategorieProjection.class)
public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {

//	@RestResource(path="by-origami")
//	public List<Categorie> findByOrigamiId(@Param("id") int id);
	
	
	@RestResource(path="by-origami")
public List<Categorie> getAllByOrigamisId(@Param("id") int id);

}
