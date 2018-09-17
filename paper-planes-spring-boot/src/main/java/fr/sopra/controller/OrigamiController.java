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

import fr.sopra.dao.IDAOCategorie;
import fr.sopra.dao.IDAOEtape;
import fr.sopra.dao.IDAOOrigami;
import fr.sopra.model.Origami;
import fr.sopra.model.enumerateur.Niveau;

@Controller
@RequestMapping("/origami")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class OrigamiController {

	@Autowired 
	private IDAOOrigami daoOri;
	
	@Autowired 
	private IDAOCategorie daoCat;
	
	@Autowired 
	private IDAOEtape daoEtap;
	
	@GetMapping(value="/read")
	public String readOrigami(Model model, @RequestParam(defaultValue="1") int id) {
		
		model.addAttribute("etapes", daoEtap.findByOrigamiIdOrderByOrdre(id));
		model.addAttribute("origamis", daoOri.findAll());
		model.addAttribute("categories", daoCat.findAll());
		return "origami";
		
	}
	
	@GetMapping(value="/delete")
	public String deleteOrigami(@RequestParam int id, Model model) {

		model.addAttribute("id", id);
		daoOri.deleteById(id);
		return "redirect:/origami/read";
	}
	
	@GetMapping(value="/update") 
	public String updateOrigamiGet (@RequestParam int id, Model model) {
		
		Origami origami = daoOri.findById(id).get();
		model.addAttribute("niveaux", Niveau.values());
		model.addAttribute("origami", origami);
		model.addAttribute("etapes", daoEtap.findByOrigamiIdOrderByOrdre(id));
		model.addAttribute("categories", daoCat.findAll());
		model.addAttribute("id", id);
		return "create-origami";
		
	}
	
	@PostMapping(value="/update") 
	public String updateOrigamiPost (@ModelAttribute Origami origami){

		daoOri.save(origami);		
		return "redirect:/origami/read";
		
	}
	
	@GetMapping(value="/create") 
	public String createOrigamiGet (Model model) {
		model.addAttribute("niveaux", Niveau.values());
		model.addAttribute("etapes", daoEtap.findAll());
		model.addAttribute("categories", daoCat.findAll());
		return "create-origami";
		
	}
	
	@PostMapping(value="/create") 
	public String createOrigamiPost (@ModelAttribute Origami origami) {
		daoOri.save(origami);
		return "redirect:/origami/read";
		
	}
	
	@GetMapping("/dispo")
	public String getDispo(@RequestParam Integer id) {
		
		Origami toSetDispo =  daoOri.findById(id).get();
		toSetDispo.setDispo(true);
		daoOri.save(toSetDispo);
			
		return "redirect:/origami/read";

	}
	
	@GetMapping("/non-dispo")
	public String getNonDispo(@RequestParam Integer id) {
		
		Origami toSetDispo =  daoOri.findById(id).get();
		toSetDispo.setDispo(false);
		daoOri.save(toSetDispo);
			
		return "redirect:/origami/read";

	}
	
}
