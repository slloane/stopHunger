package com.app.projet.controller;



import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.projet.model.Association;
import com.app.projet.model.Boulangerie;
import com.app.projet.model.Menage;
import com.app.projet.model.Restaurant;
import com.app.projet.service.AppelsAuxDonsService;
import com.app.projet.service.AssociationService;
import com.app.projet.service.BoulangerieService;
import com.app.projet.service.MenageService;
import com.app.projet.service.OffreService;
import com.app.projet.service.RestaurantService;



@Controller
public class MainController {
	
	
	@Autowired
	private BoulangerieService BoulangerieService;
	@Autowired
	private RestaurantService RestaurantService;
	@Autowired
	private MenageService MenageService;
	@Autowired
	private AssociationService AssociationService;
	@Autowired
	private OffreService OffreService;
	@Autowired
	private AppelsAuxDonsService AppelsAuxDonsService;
	
	@GetMapping("/home")
	public String viewHomePage(Model model) {
		long B = BoulangerieService.count();
		model.addAttribute("B",B);
		long R = RestaurantService.count();
		model.addAttribute("R",R);
		long M = MenageService.count();
		model.addAttribute("M",M);
		long A = AssociationService.count();
		model.addAttribute("A",A);
		long O = OffreService.count();
		model.addAttribute("O",O);
		long D = AppelsAuxDonsService.count();
		model.addAttribute("D",D);
		
		return "Boulangerie/homePage";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String home() {
		
		return "indexLogout";
	}
	
	
	   
	   @GetMapping("/Association/{id}")
	   public String getUserA(@PathVariable(value = "id") Long id, Model model)
	   {
		   model.addAttribute(id);
		   Association b= AssociationService.getAssociationById(id);
		   model.addAttribute("Association",b);
	      return "Association/standard";
	   }
	   @GetMapping("/Boulangerie/{id}")
	   public String getUserB(@PathVariable(value = "id") Long id, Model model)
	   {
		   model.addAttribute(id);
		   Boulangerie b= BoulangerieService.getBoulangerieById(id);
		   model.addAttribute("Boulangerie",b);
	      return "Boulangerie/standard";
	   }
	   @GetMapping("/Restaurant/{id}")
	   public String getUserR(@PathVariable(value = "id") Long id, Model model)
	   {
		   model.addAttribute(id);
		   Restaurant b= RestaurantService.getRestaurantById(id);
		   model.addAttribute("Restaurant",b);
		   model.addAttribute(id);
	      return "Restaurant/standard";
	   }
	   @GetMapping("/Menage/{id}")
	   public String getUserM(@PathVariable(value = "id") Long id, Model model)
	   {
		   model.addAttribute(id);
		   Menage b= MenageService.getMenageById(id);
		   model.addAttribute("Menage",b);
		   model.addAttribute(id);
	      return "Menage/standard";
	   }

	   
}
