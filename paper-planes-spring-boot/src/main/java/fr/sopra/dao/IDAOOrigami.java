package fr.sopra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Origami;
import fr.sopra.projection.OrigamiProjection;

@CrossOrigin("*")
@RepositoryRestResource(excerptProjection=OrigamiProjection.class)
public interface IDAOOrigami extends JpaRepository<Origami, Integer>{

@RestResource(path="by-nom")
public List<Origami> findByNomOrderByNom(@Param("nom") String nom);



@RestResource(path="by-nom-containing")
public List<Origami> findByNomContaining(@Param("nom") String nom);

}
