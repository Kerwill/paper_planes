package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;


import fr.sopra.model.Etape;
@CrossOrigin("*")
public interface IDAOEtape extends JpaRepository<Etape, Integer> {

	@Query("Select e from Etape e left join fetch e.origami where e.id = :id")	
	
	public Etape findByIdFetchOrigami(@Param("id") int id);

	}
	 
	

