package fr.sopra.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Categorie;
import fr.sopra.model.Origami;
@CrossOrigin("*")
public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {

	@RestResource(path="by-origami")
	public List<Categorie> findByOrigamiId(@Param("id") int id);

}
