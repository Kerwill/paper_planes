package fr.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import fr.sopra.dao.IDAOCategorie;
import fr.sopra.model.Categorie;

@Controller
public class CategorieController {
	@Autowired
	private IDAOCategorie daoCategorie;
	
	@GetMapping("/categorie")
	public String listerCategorie(Model model){
		model.addAttribute("categories", daoCategorie.findAll());
		return "categorie";
	}
	
	@GetMapping("/ajoutcategorie")
	public String ajoutCategorie(Model model){
		model.addAttribute("categories", daoCategorie.findAll());
		return "ajoutcategorie";
	}
	
	
	
	@PostMapping({"/ajoutcategorie"})
	public String addCategorie(@RequestParam String nom) {
		
		Categorie myCategorie = new Categorie();
			
		myCategorie.setNom(nom);
		
		daoCategorie.save(myCategorie);
		
		return "redirect:/categorie";
	}

	@GetMapping("/supprimercategorie")
	public String suppr(@RequestParam int id) {
	        Categorie nouveauCategorie = new Categorie();
	        nouveauCategorie.setId(id);
	        daoCategorie.delete(nouveauCategorie);
	        return "redirect:/categorie";
	}
	
	@GetMapping("/editcategorie")
	public String edit(@RequestParam int idCategorie, Model model) {
		
		model.addAttribute("categorie", daoCategorie.findById(idCategorie).get());
		
	
	return "edit";
	}
	
	@PostMapping({"/editcategorie"})
	public String edit2(@ModelAttribute Categorie categorie) {
		
		
		daoCategorie.save(categorie);
		
		return "redirect:/produit";
	}
	
	
}


