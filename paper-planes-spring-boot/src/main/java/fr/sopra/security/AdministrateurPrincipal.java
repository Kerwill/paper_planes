package fr.sopra.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.sopra.model.Administrateur;

public class AdministrateurPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Administrateur administrateur;
	
	public AdministrateurPrincipal(Administrateur administrateur) {
		if (administrateur == null) {
			throw new UsernameNotFoundException("L'administrateur n'existe pas.");
		}
		this.administrateur = administrateur;
	}
	

	public Collection<? extends GrantedAuthority> getAuthorities() {
	List<GrantedAuthority> myAuthorities = new ArrayList<GrantedAuthority>();
	
	if (this.administrateur.isTechnicien()) {
		myAuthorities.add(new SimpleGrantedAuthority("ROLE_TECH"));
	}
	else {
		myAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	return myAuthorities;
	}
	
	

	public String getPassword() {
	return this.administrateur.getPassword();
	}

	public String getUsername() {
	return this.administrateur.getUsername();
	}


	public boolean isAccountNonExpired() {
	return true;
	}
	
	public boolean isAccountNonLocked() {
	return true;
	}

	public boolean isCredentialsNonExpired() {
	return true;
	}

	public boolean isEnabled() {
	return true;
	}


	
}