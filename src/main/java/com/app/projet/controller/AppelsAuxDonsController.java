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
import com.app.projet.model.Association;
import com.app.projet.model.Boulangerie;
import com.app.projet.model.Menage;
import com.app.projet.model.Restaurant;
import com.app.projet.service.AssociationService;
import com.app.projet.service.BoulangerieService;
import com.app.projet.service.RestaurantService;
import com.app.projet.service.MenageService;
import com.app.projet.service.AppelsAuxDonsService;

@Controller
public class AppelsAuxDonsController {

	@Autowired
	private AppelsAuxDonsService AppelsAuxDonsService;
	
	@Autowired
	private AssociationService AssociationService;
	
	@Autowired
	private BoulangerieService BoulangerieService;
	@Autowired
	private RestaurantService RestaurantService;
	@Autowired
	private MenageService MenageService;
	
	@GetMapping("/Boulangerie/{id}/appels")
	public String afficherAppels(Model model, @PathVariable ( value = "id") long id) {
		model.addAttribute(id);
		Boulangerie b= BoulangerieService.getBoulangerieById(id);
		   model.addAttribute("Boulangerie",b);
		return findPaginatedAppels(1, "id", "asc", model);
	}
	
	@GetMapping("/Boulangerie/Appels/page/{pageNo}")
	public String findPaginatedAppels(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<AppelsAuxDons> page = AppelsAuxDonsService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<AppelsAuxDons> listAppelsAuxDons = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listAppelsAuxDons", listAppelsAuxDons);
		return "Boulangerie/appels_affichage";
	}
	
	@GetMapping("/Restaurant/{id}/appels")
	public String afficherAppels1(Model model,@PathVariable ( value = "id") long id) {
		model.addAttribute(id);
		Restaurant b= RestaurantService.getRestaurantById(id);
		   model.addAttribute("Restaurant",b);
		return findPaginatedAppels1(1, "id", "asc", model);
	}

	
	@GetMapping("/Restaurant/Appels/page/{pageNo}")
	public String findPaginatedAppels1(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 20;
		
		Page<AppelsAuxDons> page = AppelsAuxDonsService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<AppelsAuxDons> listAppelsAuxDons = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listAppelsAuxDons", listAppelsAuxDons);
		return "Restaurant/appels_affichage";
	}
	
	@GetMapping("/Menage/{id}/appels")
	public String afficherAppels2(Model model,@PathVariable ( value = "id") long id) {
		model.addAttribute("listAppelsAuxDons", AppelsAuxDonsService.getAllAppelsAuxDons());
		model.addAttribute(id);
		Menage b= MenageService.getMenageById(id);
		   model.addAttribute("Menage",b);
		return "Menage/appels_affichage";
	}

	
	@GetMapping("/Boulangerie/{id}/Association/infos/{id1}")
	public String showFormForUpdateOffre(@PathVariable ( value = "id") long id,@PathVariable ( value = "id1") long id1, Model model) {
		AppelsAuxDons AppelsAuxDons = AppelsAuxDonsService.getAppelsAuxDonsById(id1);
		model.addAttribute("AppelsAuxDons", AppelsAuxDons);
		model.addAttribute(id);
		Boulangerie b= BoulangerieService.getBoulangerieById(id);
		   model.addAttribute("Boulangerie",b);
		return "Boulangerie/Association_infos";
	}
	
	@GetMapping("/Restaurant/{id}/Association/infos/{id1}")
	public String showFormForUpdateOffre1(@PathVariable ( value = "id") long id,@PathVariable ( value = "id1") long id1, Model model) {
		AppelsAuxDons AppelsAuxDons = AppelsAuxDonsService.getAppelsAuxDonsById(id1);
		model.addAttribute("AppelsAuxDons", AppelsAuxDons);
		model.addAttribute(id);
		Restaurant b= RestaurantService.getRestaurantById(id);
		   model.addAttribute("Restaurant",b);
		return "Restaurant/Association_infos";
	}
	
	@GetMapping("/Menage/{id}/Association/infos/{id1}")
	public String showFormForUpdateOffre2(@PathVariable ( value = "id") long id,@PathVariable ( value = "id1") long id1 ,Model model) {
		AppelsAuxDons AppelsAuxDons = AppelsAuxDonsService.getAppelsAuxDonsById(id1);
		model.addAttribute("AppelsAuxDons", AppelsAuxDons);
		model.addAttribute(id);
		Menage b= MenageService.getMenageById(id);
		   model.addAttribute("Menage",b);
		return "Menage/Association_infos";
	}
	
	@GetMapping("/Association/{id}/appels")
    public String gestionAppels(@PathVariable(value = "id") Long id, Model model) {
		Association Association = AssociationService.getAssociationById(id);
		model.addAttribute("appels", Association.listeAppels);
		model.addAttribute("Association", Association);
		return "Association/appels_gestion";
	}
	
	@GetMapping("/Association/{id}/showNewAppelsAuxDonsForm")
	public String showNewAppelsAuxDonsForm(@PathVariable(value = "id") Long id, Model model) {
		Association Association = AssociationService.getAssociationById(id);
		model.addAttribute("Association", Association);
		AppelsAuxDons AppelsAuxDons = new AppelsAuxDons();
		model.addAttribute("AppelsAuxDons", AppelsAuxDons);
		return "Association/new_appel";
	}
	
	@PostMapping("/Association/{id}/saveAppelsAuxDons")
	public String saveAppelsAuxDons(@PathVariable(value = "id") Long id, @ModelAttribute("AppelsAuxDons") AppelsAuxDons AppelsAuxDons) {
		Association Association = AssociationService.getAssociationById(id);
		Association.addAppel(AppelsAuxDons);
		AppelsAuxDonsService.saveAppelsAuxDons(AppelsAuxDons);
		return "redirect:/Association/{id}/appels";
	}
	
	@GetMapping("/Association/{id}/showFormForUpdateAppels/{id2}")
	public String showFormAppelForUpdate(@PathVariable ( value = "id") long id, Model model, @PathVariable (value = "id2") long id2) {
		AppelsAuxDons AppelsAuxDons = AppelsAuxDonsService.getAppelsAuxDonsById(id2);
		Association Association = AssociationService.getAssociationById(id);
		model.addAttribute("AppelsAuxDons", AppelsAuxDons);
		model.addAttribute("Association", Association);
		return "Association/update_appel";
	}
	
	@GetMapping("/Association/{id}/deleteAppelsAuxDons/{id2}")
	public String deleteAppelsAuxDons(@PathVariable (value = "id") long id, @PathVariable (value = "id2") long id2) {
		
		this.AppelsAuxDonsService.deleteAppelsAuxDonsById(id2);
		return "redirect:/Association/{id}/appels";
	}
}