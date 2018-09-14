package fr.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
public class CategorieController {
	@Autowired
	private IDAOCategorie daoCategorie;
	
	@GetMapping("/read")
	public String readCategorie(Model model){
		model.addAttribute("categories", daoCategorie.findAll());
		return "categorie";
	}
	
	@GetMapping("/create")
	public String createCategorieGet(Model model){
		model.addAttribute("categories", daoCategorie.findAll());
	
		return "create-categorie";
	}
	
	@PostMapping({"/create"})
	public String createCategoriePost(@ModelAttribute Categorie categorie) {
		
		daoCategorie.save(categorie);
		
		return "redirect:/categorie/read";
	}

	@GetMapping("/delete")
	public String deleteCategorie(@RequestParam int id) {
	        Categorie nouveauCategorie = new Categorie();
	        nouveauCategorie.setId(id);
	        daoCategorie.delete(nouveauCategorie);
	        return "redirect:/categorie/read";
	}
	
	
	@GetMapping("/update")
	public String updateCategorieGet(@RequestParam int id, Model model) {
		Categorie categorie = daoCategorie.findById(id).get();
		model.addAttribute("categories", daoCategorie.findAll());
		model.addAttribute("categorie", categorie);
		
	return "create-categorie";
	}
	
	@PostMapping({"/update"})
	public String updateCategoriePost(@ModelAttribute Categorie categorie) {
		
		
		daoCategorie.save(categorie);
		
		return "redirect:/categorie/read";
	}
	
	
	
	
	
}