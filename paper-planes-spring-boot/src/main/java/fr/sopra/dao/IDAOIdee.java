package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Idee;
import fr.sopra.projection.IdeeProjection;

@CrossOrigin("*")
@RepositoryRestResource(excerptProjection=IdeeProjection.class)
public interface IDAOIdee extends JpaRepository<Idee, Integer>{

}