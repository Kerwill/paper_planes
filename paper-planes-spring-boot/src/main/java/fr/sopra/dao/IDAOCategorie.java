package fr.sopra.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.Categorie;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {



}
