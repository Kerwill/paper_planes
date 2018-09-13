package fr.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ewavy.model.Produit;
import fr.sopra.dao.IDAOCategorie;
import fr.sopra.dao.IDAOOrigami;
import fr.sopra.model.Origami;

@Controller
@RequestMapping("/origami")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class OrigamiController {

	@Autowired 
	private IDAOOrigami daoOri;
	
	@Autowired 
	private IDAOCategorie daoCat;
	
	@GetMapping(value="/read")
	public String readOrigami(Model model) {

		model.addAttribute("origamis", daoOri.findAll());
		return "origami";
		
	}
	
	@GetMapping(value="/delete")
	public String deleteOrigami(@RequestParam int id, Model model) {

		model.addAttribute("id", id);
		daoOri.deleteById(id);
		return "redirect:/origami/list";
	}
	
	@GetMapping(value="/update") 
	public String updateOrigamiGet (
			@RequestParam int id, 
			Model model) {
		
		Origami origami = daoOri.findById(id).get();
		model.addAttribute("origami", origami);
		model.addAttribute("categories", daoCat.findAll());
		model.addAttribute("id", id);
		return "origami-edit";
		
	}
	
	@PostMapping(value="/update") 
	public String updateOrigamiPost (@ModelAttribute Origami origami){

		daoOri.save(origami);		
		return "redirect:/produit/list";
		
	}
	
	@GetMapping(value="/create") 
	public String createOrigamiGet (Model model) {

		model.addAttribute("categories", daoCat.findAll());
		return "origami-edit";
		
	}
	
	@PostMapping(value="/create") 
	public String createOrigamiPost (@ModelAttribute Origami origami) {
		
		daoOri.save(origami);
		return "redirect:/origami/list";
		
	}
	
}
