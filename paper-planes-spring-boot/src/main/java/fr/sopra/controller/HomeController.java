package fr.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOOrigami;

@Controller
public class HomeController {
	
	@Autowired 
	private IDAOOrigami daoOrigami;
	
//	@GetMapping("/home")
//	public String home(String username, Model model) {
//		model.addAttribute("administrateur", username);
//		return "home";
//	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value="/home")
	public String readOrigami(Model model, @RequestParam(defaultValue="1") int id) {
		
		model.addAttribute("origamis", daoOrigami.findAll());
		return "home";
		
	}
}

	