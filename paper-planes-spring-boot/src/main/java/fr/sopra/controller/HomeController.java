package fr.sopra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	   org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "login";
	}
	
	@GetMapping(value="/home")
	public String readOrigami(Model model, @RequestParam(defaultValue="1") int id) {
		
		model.addAttribute("origamis", daoOrigami.findAll());
		return "home";
		
	}
}

	