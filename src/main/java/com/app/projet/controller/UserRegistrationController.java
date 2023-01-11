package com.app.projet.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.projet.model.Utilisateur;

import com.app.projet.service.UtilisateurService;
import com.app.projet.controller.dto.UserRegistrationDto;
import com.app.projet.model.Association;
import com.app.projet.model.Boulangerie;
import com.app.projet.model.Restaurant;
import com.app.projet.model.Menage;
import com.app.projet.service.AssociationService;
import com.app.projet.service.BoulangerieService;
import com.app.projet.service.RestaurantService;
import com.app.projet.service.MenageService;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UtilisateurService utilisateurService;
	private BoulangerieService BoulangerieService;
	private RestaurantService RestaurantService;
	private AssociationService AssociationService;
	private MenageService MenageService;

	
	public UserRegistrationController(UtilisateurService utilisateurService, BoulangerieService BoulangerieService, RestaurantService RestaurantService, AssociationService AssociationService, MenageService MenageService) {
		super();
		this.utilisateurService = utilisateurService;
		this.BoulangerieService = BoulangerieService;
		this.RestaurantService = RestaurantService;
		this.AssociationService = AssociationService;
		this.MenageService = MenageService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		Utilisateur u = utilisateurService.save(registrationDto);
		
		if(registrationDto.getCategorieCmpte().equalsIgnoreCase("boulangerie")) {
			Boulangerie b = new Boulangerie();
			b.setAdresse(registrationDto.getAdresse());
			b.setBio(registrationDto.getBio());
			b.setEmail(registrationDto.getEmail());
			b.setNomUtilisateur(registrationDto.getNomUtilisateur());
			b.setVille(registrationDto.getVille());
			b.setPassword(registrationDto.getPassword());
			BoulangerieService.saveBoulangerie(b);
		}
		if(registrationDto.getCategorieCmpte().equalsIgnoreCase("restaurant")) {
			Restaurant b = new Restaurant();
			b.setAdresse(registrationDto.getAdresse());
			b.setBio(registrationDto.getBio());
			b.setEmail(registrationDto.getEmail());
			b.setNomUtilisateur(registrationDto.getNomUtilisateur());
			b.setVille(registrationDto.getVille());
			b.setPassword(registrationDto.getPassword());
			RestaurantService.saveRestaurant(b);
		}
		if(registrationDto.getCategorieCmpte().equalsIgnoreCase("association")) {
			Association b = new Association();
			b.setAdresse(registrationDto.getAdresse());
			b.setBio(registrationDto.getBio());
			b.setEmail(registrationDto.getEmail());
			b.setNomUtilisateur(registrationDto.getNomUtilisateur());
			b.setVille(registrationDto.getVille());
			b.setPassword(registrationDto.getPassword());
			AssociationService.saveAssociation(b);
		}
		if(registrationDto.getCategorieCmpte().equalsIgnoreCase("menage")) {
			Menage b = new Menage();
			b.setAdresse(registrationDto.getAdresse());
			b.setBio(registrationDto.getBio());
			b.setEmail(registrationDto.getEmail());
			b.setNomUtilisateur(registrationDto.getNomUtilisateur());
			b.setVille(registrationDto.getVille());
			b.setPassword(registrationDto.getPassword());
			MenageService.saveMenage(b);
		}
		
		
		return "redirect:/registration?success";
	}
	
	
	
}
