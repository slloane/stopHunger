package com.app.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.app.projet.model.Association;
import com.app.projet.model.Boulangerie;
import com.app.projet.model.Offre;
import com.app.projet.model.Restaurant;
import com.app.projet.service.AssociationService;

@Controller
public class AssociationController {
	
	@Autowired
	private AssociationService AssociationService;

	
	
	@GetMapping("/Association/list")
	public String afficherAppels(Model model) {
		return findPaginatedAssociation(1, "nomUtilisateur", "asc", model);
	}
	
	@GetMapping("/page/{pageANo}")
	public String findPaginatedAssociation(@PathVariable (value = "pageANo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 20;
		
		Page<Association> page = AssociationService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Association> Associations = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("Associations", Associations);
		return "list_associations";
	}
	
	
	
	
}
