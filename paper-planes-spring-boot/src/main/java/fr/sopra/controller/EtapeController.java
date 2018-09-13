package fr.sopra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOEtape;
import fr.sopra.model.Etape;

@Secured({ "ROLE_ADMIN"})
@Controller
public class EtapeController {

	@Autowired
	private IDAOEtape daoetape;

	@Secured({"ROLE_ADMIN","ROLE_TECH"})
	@GetMapping({ "/etape" })
	public String readEtape(Model model) {
		model.addAttribute("etapes", daoetape.findAll());
		return "etape";

	}

	// AJOUTER ETAPE

	// 1 GET POUR RECUPERER FORMULAIRE
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping({ "/create-etape" })
	public String createEtape(Model model) {
		model.addAttribute("etapes", daoetape.findAll());
		return "create-etape";

	}

	// 2 POST POUR ENVOYER DONNES
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping({ "/create-etape" })
	
	public String createEtape(@RequestParam int id, @RequestParam String nom, @RequestParam String descriptif, 
			@RequestParam String image, @RequestParam String video, @RequestParam int ordre, Model model ) {
		
		Etape myEtape = new Etape();
		myEtape.setId(id);
		myEtape.setDescriptif(descriptif);
		myEtape.setImage(image);
		myEtape.setVideo(video);
		myEtape.setOrdre(ordre);

		daoetape.save(myEtape);
		return "redirect:/etape";
	}

	// EFFACER ETAPE
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping({ "/etape" })
	public String deleteEtape(@RequestParam int id, Model model) {
		
		Etape myEtape = new Etape();
		myEtape.setId(id);
		daoetape.deleteById(id);

		return "redirect:/etape";

	}

	// MODIFIER ETAPE
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping({ "/etape" })
	public String updateEtapeGet(@RequestParam int id, Model model) {

		model.addAttribute("etape", daoetape.findById(id).get());

		return "formulaireetape";

	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping({ "/etape" })
	public String updateEtapePost(@RequestParam int id, @RequestParam String nom, @RequestParam String descriptif, 
			@RequestParam String image, @RequestParam String video, @RequestParam int ordre, Model model ) {
	
		Etape myEtape = new Etape();
		myEtape.setId(id);
		myEtape.setDescriptif(descriptif);
		myEtape.setImage(image);
		myEtape.setVideo(video);
		myEtape.setOrdre(ordre);

		daoetape.save(myEtape);
		return "redirect:/etape";
	}
	
	}
