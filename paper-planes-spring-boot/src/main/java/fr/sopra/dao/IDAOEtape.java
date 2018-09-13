package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.Etape;

public interface IDAOEtape extends JpaRepository<Etape, Integer> {

}
