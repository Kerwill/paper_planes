package fr.sopra.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Categorie;
@CrossOrigin("*")
public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {

	public Optional<Categorie> findByNom(@Param("nom") String nom);
	
	public List<Categorie> findByOrigamisId(@Param("id") int id);
	
}
