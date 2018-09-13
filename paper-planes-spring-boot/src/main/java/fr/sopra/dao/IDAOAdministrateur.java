package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Administrateur;
@CrossOrigin("*")
public interface IDAOAdministrateur extends JpaRepository<Administrateur, Integer> {
	public Administrateur findByUsername(String username);
	public Administrateur findByUsernameAndPassword(String username, String password);
}
