package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.Administrateur;

public interface IDAOAdministrateur extends JpaRepository<Administrateur, Integer> {
	public Administrateur findByUsername(String username);
	public Administrateur findByUsernameAndPassword(String username, String password);
}
