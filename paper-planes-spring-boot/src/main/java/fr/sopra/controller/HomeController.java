package fr.sopra.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HomeController {
	
	@GetMapping("/")
	public String home(@RequestParam(defaultValue = "visiteur") String username, Model model) {
		model.addAttribute("administrateur", username);
		return "home";
	}
}

	