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
import fr.sopra.dao.IDAOOrigami;
import fr.sopra.model.Etape;



@Controller
@RequestMapping("/etape")

public class EtapeController {

	@Autowired
	private IDAOOrigami daoOri;
	
	@Autowired
	private IDAOEtape daoEtape;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
	@GetMapping("/read")
	public String readEtape(Model model) {
		model.addAttribute("etapes", daoEtape.findAll());
		return "etape";

	}

	// AJOUTER ETAPE

	// 1 GET POUR RECUPERER FORMULAIRE

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/create")
//	public String createEtapeGet(Model model) {
//		model.addAttribute("etapes", daoEtape.findAll());
//		return "create-etape";

		public String createEtape(Model model) {
			
		model.addAttribute("origamis", daoOri.findAll());

		
			return "create-etape";
		}	
		
	// 2 POST POUR ENVOYER DONNES

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")

	public String createEtapePost(@ModelAttribute Etape etape) {

		daoEtape.save(etape);
		return "redirect:/etape/read";
	}

	// EFFACER ETAPE
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete")
	public String deleteEtape(@RequestParam int id, Model model) {

//		model.addAttribute("id", id);

		
		Etape myEtape = new Etape();
		myEtape.setId(id);
		daoEtape.deleteById(id);

		return "redirect:/etape";

	}

	// MODIFIER ETAPE
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
	@GetMapping("/update")
	public String updateEtapeGet(@RequestParam int id, Model model) {

		model.addAttribute("etape", daoEtape.findById(id).get());

		model.addAttribute("origamis", daoOri.findAll());
		
		return "create-etape";

	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
	@PostMapping("/update")
	public String updateEtapePost(@ModelAttribute Etape etape) {

		daoEtape.save(etape);
		return "redirect:/etape/read";
	}

	
}
