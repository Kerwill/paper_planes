package fr.sopra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.sopra.AdministrateurPrincipal;
import fr.sopra.dao.IDAOAdministrateur;
import fr.sopra.model.Administrateur;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	IDAOAdministrateur daoAdministrateur;

//	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return new UtilisateurPrincipal(this.daoUtilisateur.findByUsername(username));
		
		Administrateur myAdministrateur = this.daoAdministrateur.findByUsername(username);
		AdministrateurPrincipal myPrincipal = new AdministrateurPrincipal(myAdministrateur);
		return myPrincipal;
		
	}
}