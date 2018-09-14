package fr.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOAdministrateur;
import fr.sopra.model.Administrateur;

@Controller
@RequestMapping("/administration")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
public class AdministrateurController {

	@Autowired
	private IDAOAdministrateur daoAdministrateur;

	@GetMapping({ "/home-admin" })
public String login() {
		
		return "home-admin";
	}
	
//	lister les administrateurs/techniciens
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
	@GetMapping("/read")
	public String readAdmin(Model model) {
		model.addAttribute("administrateurs", daoAdministrateur.findAll());
		return "administration";
	}

//	Etape 1 : modifier les administrateurs/techniciens -- find by id
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/update")
	public String updateAdminGet(@RequestParam int id, Model model) {
		model.addAttribute("administrateur", daoAdministrateur.findById(id).get());
		return "create-administration";
	}

//	Etape 2 : modifier les administrateurs -- modifier les champs
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public String updateAdminPost(@RequestParam int id, @RequestParam boolean isTechnicien, @RequestParam String username,
			@RequestParam String password, Model model) {
		Administrateur myAdministrateur = new Administrateur();

		myAdministrateur.setId(id);
		myAdministrateur.setUsername(username);
		myAdministrateur.setPassword(password);
		myAdministrateur.setTechnicien(isTechnicien);

		daoAdministrateur.save(myAdministrateur);
		return "redirect:/administration";
	}

//	supprimer les administrateurs/techniciens
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete")
	public String deleteAdmin(@RequestParam int id, Model model) {
		Administrateur myAdministrateur = new Administrateur();
		myAdministrateur.setId(id);

		daoAdministrateur.deleteById(id);
		return "redirect:/administration";
	}

//creer administrateurs/techniciens	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/create")
	public String createAdminGet(Model model) {
		model.addAttribute("administrateurs", daoAdministrateur.findAll());
		return "create-administration";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public String createAdminPost(@RequestParam boolean isTechnicien, @RequestParam String username, @RequestParam String password, Model model) {
		Administrateur myAdministrateur = new Administrateur();

		myAdministrateur.setUsername(username);
		myAdministrateur.setPassword(password);
		
		myAdministrateur.setTechnicien(isTechnicien);
		
		
		daoAdministrateur.save(myAdministrateur);
		return "redirect:/administration";
	}
	
}
