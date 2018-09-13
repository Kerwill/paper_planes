package fr.sopra.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Origami;

@CrossOrigin("*")
public interface IDAOOrigami extends JpaRepository<Origami, Integer>{

//@RestResource(path="by-nom")
public Set<Origami> findByNom(@Param("nom") int nom);

}
