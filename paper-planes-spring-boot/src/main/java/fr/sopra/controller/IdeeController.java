package fr.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.sopra.dao.IDAOIdee;
import fr.sopra.model.Idee;


@Controller
@RequestMapping("/idee")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TECH')")
public class IdeeController {
	@Autowired
	private IDAOIdee daoIdee;
	
	@GetMapping("/read")
	public String readCategorie(Model model){
		model.addAttribute("idees", daoIdee.findAll());
		return "idee";
	}
	
	@GetMapping("/archive")
	public String getDispo(@RequestParam Integer id) {
		
		Idee toSetArchive =  daoIdee.findById(id).get();
		toSetArchive.setArchive(true);
		daoIdee.save(toSetArchive);
			
		return "redirect:/idee/read";

	}
	
	@GetMapping("/non-archive")
	public String getNonDispo(@RequestParam Integer id) {
		
		Idee toSetArchive=  daoIdee.findById(id).get();
		toSetArchive.setArchive(false);
		daoIdee.save(toSetArchive);
			
		return "redirect:/idee/read";

	}


}