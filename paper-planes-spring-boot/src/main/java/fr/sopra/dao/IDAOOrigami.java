package fr.sopra.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Origami;

@CrossOrigin("*")
public interface IDAOOrigami extends JpaRepository<Origami, Integer>{

@RestResource(path="by-nom")
public List<Origami> findByNomOrderByNom(@Param("nom") String nom);



@RestResource(path="by-nom-containing")
public List<Origami> findByNomContaining(@Param("nom") String nom);

}
