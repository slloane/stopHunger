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
import com.app.projet.model.Menage;
import com.app.projet.model.Restaurant;
import com.app.projet.service.AssociationService;
import com.app.projet.service.MenageService;
import com.app.projet.service.RestaurantService;

@Controller
public class RestaurantController {
	
	@Autowired
	private RestaurantService RestaurantService;
	
	@Autowired
	private AssociationService AssociationService;
	@Autowired
	private MenageService MenageService;
	
	
	
	@GetMapping("/Restaurant/list")
	public String afficherAppels( Model model) {
		return findPaginatedRestaurant(1, "points", "desc", model);
	}
	
	@GetMapping("/{id}/Restaurant/list")
	public String classement(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute(id);
		Menage Menage = MenageService.getMenageById(id);
		
		model.addAttribute("Menage", Menage);
		return findPaginatedRestaurant1(1, "points", "desc", model);
	}
	
	@GetMapping("/page/{pageRNo}")
	public String findPaginatedRestaurant(@PathVariable (value = "pageRNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 20;
		
		Page<Restaurant> page = RestaurantService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Restaurant> Restaurants = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("Restaurants", Restaurants);
		return "list_restaurants";
	}
	
	@GetMapping("/page/{pageR2No}")
	public String findPaginatedRestaurant1(@PathVariable (value = "pageR2No") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 20;
		
		Page<Restaurant> page = RestaurantService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Restaurant> Restaurants = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("Restaurants", Restaurants);
		return "classement_restaurant";
	}
	
	
	
	
	
	
}
