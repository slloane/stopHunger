package com.app.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.projet.model.AppelsAuxDons;
import com.app.projet.model.Association;
import com.app.projet.model.Besoin;
import com.app.projet.model.Boulangerie;
import com.app.projet.model.Menage;
import com.app.projet.model.Offre;
import com.app.projet.model.Restaurant;
import com.app.projet.service.AssociationService;
import com.app.projet.service.BesoinService;
import com.app.projet.service.BoulangerieService;
import com.app.projet.service.OffreService;
import com.app.projet.service.RestaurantService;
import com.app.projet.service.MenageService;

@Controller
public class BesoinController {
	
	@Autowired
	private BesoinService besoinService;
	@Autowired
	private OffreService OffreService;
	@Autowired
	private AssociationService AssociationService;
	@Autowired
	private BoulangerieService BoulangerieService;
	@Autowired
	private RestaurantService RestaurantService;
	@Autowired
	private MenageService MenageService;
	
	
	@GetMapping("/Boulangerie/{id}/besoins")
	public String viewBesoins(@PathVariable(value = "id") Long id, Model model ) {
		model.addAttribute("ListeBesoins", besoinService.getAllBesoins());
		model.addAttribute(id);
		 Boulangerie b= BoulangerieService.getBoulangerieById(id);
		   model.addAttribute("Boulangerie",b);
		return "Boulangerie/besoins";
	}
	@GetMapping("/Restaurant/{id}/besoins")
	public String viewBesoins2(@PathVariable(value = "id") Long id,Model model ) {
		model.addAttribute("ListeBesoins", besoinService.getAllBesoins());
		model.addAttribute(id);
		Restaurant b= RestaurantService.getRestaurantById(id);
		   model.addAttribute("Restaurant",b);
		return "Restaurant/besoins";
	}
	@GetMapping("/Menage/{id}/besoins")
	public String viewBesoins3(@PathVariable(value = "id") Long id,Model model ) {
		model.addAttribute("ListeBesoins", besoinService.getAllBesoins());
		model.addAttribute(id);
		Menage b= MenageService.getMenageById(id);
		   model.addAttribute("Menage",b);
		return "Menage/besoins";
	}
	@GetMapping("/Association/{id}/saveDemande/{id1}")
	public String saveOffre(@PathVariable(value = "id") Long id, @PathVariable(value = "id1") Long id1, Model model) {
		Offre offre1= OffreService.getOffreById(id1);
		Association Association = AssociationService.getAssociationById(id);
		offre1.addAssociation(Association);
		OffreService.saveOffre(offre1);
		Association b= AssociationService.getAssociationById(id);
		model.addAttribute("Association",b);
		
		return "Association/msgdemande";
	}
	//
	@GetMapping("/Association/{id}/listBesoins")
    public String gestionBesoins(@PathVariable(value = "id") Long id, Model model) {
		Association Association = AssociationService.getAssociationById(id);
		model.addAttribute("ListBesoins", Association.listeBesoins);
		model.addAttribute("Association", Association);
		model.addAttribute(id);
		return "Association/besoins_gestion";
	}
	@GetMapping("/Association/{id}/showNewBesoinForm")
	public String showNewBesoinForm( @PathVariable(value = "id") Long id, Model model) {
		Association Association = AssociationService.getAssociationById(id);
		model.addAttribute("Association", Association);
		Besoin besoin = new Besoin();
		model.addAttribute("besoin", besoin);
		model.addAttribute(id);
		return "Association/new_besoin";
	}
	
	@PostMapping("/Association/{id}/saveBesoin")
	public String saveBesoin(@PathVariable(value = "id") Long id,@ModelAttribute("besoin") Besoin besoin ) {
		Association Association = AssociationService.getAssociationById(id);
		Association.addBesoin(besoin);
		besoinService.saveBesoin(besoin);
		return "redirect:/Association/{id}/listBesoins";
	}
	
	@GetMapping("/Association/{id}/showFormForUpdateBesoin/{id2}")
	public String showFormForUpdateBesoin(@PathVariable ( value = "id") long id, Model model, @PathVariable (value = "id2") long id2) {
		Besoin besoin = besoinService.getBesoinById(id2);
		Association Association = AssociationService.getAssociationById(id);
		model.addAttribute("besoin", besoin);
		model.addAttribute("Association", Association);
		return "Association/update_besoin";
	}
	
	
	@GetMapping("/Association/{id}/deleteBesoin/{id2}")
	public String deleteBesoin(@PathVariable (value = "id") long id, @PathVariable (value = "id2") long id2) {
		
		this.besoinService.deleteBesoinById(id2);
		
		return "redirect:/Association/{id}/listBesoins";
	}
	
	@GetMapping("/Restaurant/{id}/Besoin/infos/{id2}")
	public String showFormForUpdateOffre(@PathVariable ( value = "id") long id, Model model, @PathVariable (value = "id2") long id2) {
		Besoin besoin = besoinService.getBesoinById(id2);
		model.addAttribute("besoin", besoin);
		model.addAttribute(id);
		Restaurant b= RestaurantService.getRestaurantById(id);
		   model.addAttribute("Restaurant",b);
		return "Restaurant/besoin_infos";
	}
	
	@GetMapping("/Boulangerie/{id}/Besoin/infos/{id2}")
	public String showFormForUpdateOffre1(@PathVariable ( value = "id") long id, Model model, @PathVariable (value = "id2") long id2) {
		Besoin besoin = besoinService.getBesoinById(id2);
		model.addAttribute("besoin", besoin);
		model.addAttribute(id);
		Boulangerie b= BoulangerieService.getBoulangerieById(id);
		   model.addAttribute("Boulangerie",b);
		return "Boulangerie/besoin_infos";
	}
	
	@GetMapping("/Menage/{id}/Besoin/infos/{id2}")
	public String showFormForUpdateOffre2(@PathVariable ( value = "id") long id, Model model, @PathVariable (value = "id2") long id2) {
		Besoin besoin = besoinService.getBesoinById(id2);
		model.addAttribute("besoin", besoin);
		model.addAttribute(id);
		Menage b= MenageService.getMenageById(id);
		   model.addAttribute("Menage",b);
		return "Menage/besoin_infos";
	}
	
}
