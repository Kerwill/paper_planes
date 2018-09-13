package fr.sopra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(String username, Model model) {
		model.addAttribute("administrateur", username);
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}

	