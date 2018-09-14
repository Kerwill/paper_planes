package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;


import fr.sopra.model.Etape;
@CrossOrigin("*")
public interface IDAOEtape extends JpaRepository<Etape, Integer> {
	
	public Etape findByOrigamiId(@Param("id") int id);
	
	
	}
	 
	

