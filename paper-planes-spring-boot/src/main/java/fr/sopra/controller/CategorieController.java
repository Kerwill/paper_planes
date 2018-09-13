package fr.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOCategorie;
import fr.sopra.model.Categorie;


@Controller
@RequestMapping("/categorie")
public class CategorieController {
	@Autowired
	private IDAOCategorie daoCategorie;
	
	@GetMapping("/read")
	public String readCategorie(Model model){
		model.addAttribute("categories", daoCategorie.findAll());
		return "redirect:/categorie";
	}
	
	@GetMapping("/create")
	public String createCategorieGet(Model model){
		model.addAttribute("categories", daoCategorie.findAll());
		return "create";
	}
	
	
	
	@PostMapping({"/create"})
	public String createCategoriePost(@RequestParam String nom) {
		
		Categorie myCategorie = new Categorie();
			
		myCategorie.setNom(nom);
		
		daoCategorie.save(myCategorie);
		
		return "redirect:/categorie";
	}

	@GetMapping("/delete")
	public String deleteCategorie(@RequestParam int id) {
	        Categorie nouveauCategorie = new Categorie();
	        nouveauCategorie.setId(id);
	        daoCategorie.delete(nouveauCategorie);
	        return "redirect:/categorie";
	}
	
	@GetMapping("/update")
	public String updateCategorieGet(@RequestParam int idCategorie, Model model) {
		
		model.addAttribute("categorie", daoCategorie.findById(idCategorie).get());
		
	
	return "update";
	}
	
	@PostMapping({"/update"})
	public String updateCategoriePost(@ModelAttribute Categorie categorie) {
		
		
		daoCategorie.save(categorie);
		
		return "redirect:/produit";
	}
	
	
}


