package fr.sopra.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Categorie;
@CrossOrigin("*")
public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {


	
}
