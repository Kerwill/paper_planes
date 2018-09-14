package fr.sopra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;


import fr.sopra.model.Etape;
@CrossOrigin("*")
public interface IDAOEtape extends JpaRepository<Etape, Integer> {
	
	public List<Etape> findByOrigamiIdOrderByOrdre(@Param("id") int id);
	
	}
	 
	

