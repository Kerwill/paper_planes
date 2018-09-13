package fr.sopra.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class HomeController {
	
	@GetMapping("/")
	public String home(String username, Model model) {
		model.addAttribute("administrateur", username);
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}

	