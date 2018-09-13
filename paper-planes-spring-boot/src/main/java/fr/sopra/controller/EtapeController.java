package fr.sopra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
	public String listetape(Model model) {

		List<Etape> myEtapes = new ArrayList<Etape>();

		model.addAttribute("etapes", daoetape.findAll());

		return "etape";

	}

	// AJOUTER ETAPE

	// 1 GET POUR RECUPERER FORMULAIRE

	@GetMapping({ "/createEtape" })
	public String addEtape(Model model) {

		model.addAttribute("etape", daoetape.findAll());

		return "origami";

	}

	// 2 POST POUR ENVOYER DONNES

	@PostMapping({ "/createEtape" })
	
	// 	public String addProduit(@RequestParam String nom, @RequestParam float prix) {
	
	public String addEtape(@RequestParam String nom, @RequestParam String descriptif, @RequestParam String image, @RequestParam String video, @RequestParam int ordre ) {

		Etape myEtape = new Etape();

		myEtape.setDescriptif(descriptif);
		myEtape.setImage(image);
		myEtape.setVideo(video);
		myEtape.setOrdre(ordre);

		daoetape.save(myEtape);

		return "redirect:/formulaireetape";

	}

	// EFFACER ETAPE

	@GetMapping({ "/deleteEtape" })

	public String deleteEtape(@RequestParam int id) {

		daoetape.deleteById(id);

		return "redirect:/etape";

	}

	// MODIFIER ETAPE

	@GetMapping({ "/uodateEtape" })

	public String editerEtape(@RequestParam int id, Model model) {

		model.addAttribute("etape", daoetape.findById(id).get());

		return "formulaireetape";

	}

	@PostMapping({ "/modetape" })


	public String editerEtape(@ModelAttribute Etape etape) {
	
		daoetape.save(etape);

		return "redirect:/origami";
	}
	
	}
