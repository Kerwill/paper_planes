package fr.sopra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Etape;
@CrossOrigin("*")
public interface IDAOEtape extends JpaRepository<Etape, Integer> {

	
	
	@RestResource(path="by-origami-id")
	public List<Etape> findByOrigamiId(@Param("id") int id);

}
