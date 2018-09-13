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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOEtape;
import fr.sopra.model.Etape;

@Secured({ "ROLE_ADMIN"})
@Controller
@RequestMapping("/etape")
public class EtapeController {

	@Autowired
	private IDAOEtape daoEtape;

	@Secured({"ROLE_ADMIN","ROLE_TECH"})
	@GetMapping("/read")
	public String readEtape(Model model) {
		model.addAttribute("etapes", daoEtape.findAll());
		return "etape";

	}

	// AJOUTER ETAPE

	// 1 GET POUR RECUPERER FORMULAIRE

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/create")
	public String createEtape(Model model) {
		model.addAttribute("etapes", daoEtape.findAll());
		return "create-etape";

	}

	// 2 POST POUR ENVOYER DONNES

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")

	public String createEtape(@RequestParam int id, @RequestParam String nom, @RequestParam String descriptif,
			@RequestParam String image, @RequestParam String video, @RequestParam int ordre, Model model ) {

		Etape myEtape = new Etape();
		myEtape.setId(id);
		myEtape.setDescriptif(descriptif);
		myEtape.setImage(image);
		myEtape.setVideo(video);
		myEtape.setOrdre(ordre);

		daoEtape.save(myEtape);
		return "redirect:/etape";
	}

	// EFFACER ETAPE
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete")
	public String deleteEtape(@RequestParam int id, Model model) {

		Etape myEtape = new Etape();
		myEtape.setId(id);
		daoEtape.deleteById(id);

		return "redirect:/etape";

	}

	// MODIFIER ETAPE

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/update")
	public String updateEtapeGet(@RequestParam int id, Model model) {

		model.addAttribute("etape", daoEtape.findById(id).get());

		return "create-etape";

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public String updateEtapePost(@RequestParam int id, @RequestParam String nom, @RequestParam String descriptif,
			@RequestParam String image, @RequestParam String video, @RequestParam int ordre, Model model ) {

		Etape myEtape = new Etape();
		myEtape.setId(id);
		myEtape.setDescriptif(descriptif);
		myEtape.setImage(image);
		myEtape.setVideo(video);
		myEtape.setOrdre(ordre);

		daoEtape.save(myEtape);
		return "redirect:/etape";
	}

	}
