package fr.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOAdministrateur;
import fr.sopra.model.Administrateur;

@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
@Controller
public class AdministrateurController {

	@Autowired
	private IDAOAdministrateur daoAdministrateur;

//	lister les administrateurs/techniciens
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
	@GetMapping("/administration")
	public String readAdmin(Model model) {
		model.addAttribute("administrateurs", daoAdministrateur.findAll());
		return "administration";
	}

//	Etape 1 : modifier les administrateurs/techniciens -- find by id
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/administration")
	public String updateAdminGet(@RequestParam int id, Model model) {
		model.addAttribute("administrateur", daoAdministrateur.findById(id).get());
		return "create-administration";
	}

//	Etape 2 : modifier les administrateurs -- modifier les champs
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create-administration")
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
	@GetMapping("/administration")
	public String deleteAdmin(@RequestParam int id, Model model) {
		Administrateur myAdministrateur = new Administrateur();
		myAdministrateur.setId(id);

		daoAdministrateur.deleteById(id);
		return "redirect:/administration";
	}

//creer administrateurs/techniciens	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/administration")
	public String createAdminGet(Model model) {
		model.addAttribute("administrateurs", daoAdministrateur.findAll());
		return "create-administration";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create-administration")
	public String createAdminPost(@RequestParam int id, @RequestParam boolean isTechnicien, @RequestParam String username,
	@RequestParam String password, Model model) {
		Administrateur myAdministrateur = new Administrateur();

		myAdministrateur.setId(id);
		myAdministrateur.setUsername(username);
		myAdministrateur.setPassword(password);
		myAdministrateur.setTechnicien(isTechnicien);


		daoAdministrateur.save(myAdministrateur);
		return "redirect:/administration";
	}
	
}
