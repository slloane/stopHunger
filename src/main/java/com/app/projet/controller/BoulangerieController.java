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

import com.app.projet.model.AppelsAuxDons;
import com.app.projet.model.Boulangerie;
import com.app.projet.model.Menage;
import com.app.projet.model.Restaurant;
import com.app.projet.service.AppelsAuxDonsService;
import com.app.projet.service.BoulangerieService;
import com.app.projet.service.AssociationService;
import com.app.projet.service.MenageService;
import com.app.projet.service.RestaurantService;

@Controller
public class BoulangerieController {
	
	@Autowired
	private BoulangerieService BoulangerieService;
	@Autowired
	private RestaurantService RestaurantService;
	@Autowired
	private MenageService MenageService;
	@Autowired
	private AssociationService AssociationService;
	
	
	
	
	
	
	
	
	@GetMapping("/Boulangerie/list")
	public String afficherAppels(Model model) {
		return findPaginatedBoulangerie(1, "points", "desc", model);
	}
	
	@GetMapping("/{id}/Boulangerie/list")
	public String classement(@PathVariable ( value = "id") long id, Model model) {
		model.addAttribute(id);
		Menage Menage = MenageService.getMenageById(id);
		
		model.addAttribute("Menage", Menage);
		return findPaginatedBoulangerie1(1, "points", "desc", model);
	}
	
	@GetMapping("/page/{pageBNo}")
	public String findPaginatedBoulangerie(@PathVariable (value = "pageBNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 20;
		
		Page<Boulangerie> page = BoulangerieService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Boulangerie> Boulangerie = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("Boulangerie", Boulangerie);
		return "list_Boulangeries";
	}
	
	@GetMapping("/page/{pageB2No}")
	public String findPaginatedBoulangerie1(@PathVariable (value = "pageB2No") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 20;
		
		Page<Boulangerie> page = BoulangerieService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Boulangerie> Boulangerie = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("Boulangerie", Boulangerie);
		return "classement_boulangerie";
	}
	
	
}
