package fr.sopra.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Categorie;
@CrossOrigin("*")
public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {



}
