package com.app.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.projet.model.Association;
import com.app.projet.model.Offre;
import com.app.projet.service.OffreService;
import com.app.projet.service.AssociationService;

@Controller
public class OffreController {

	@Autowired
    private OffreService offreService;

	@Autowired
    private AssociationService AssociationService;
	
	@GetMapping("Association/{id}/listerOffre")
    public String viewHomePage2(@PathVariable(value = "id") Long id, Model model) {
		Association Association = AssociationService.getAssociationById(id);
		model.addAttribute("ListOffres", offreService.getAllOffre());
		model.addAttribute("Association", Association);
		return "Association/AfficherListeOffres";
	}
	
	@GetMapping("/offres/{id}")
	public String demanderOffre(@PathVariable (value = "id") long id) {
		
		this.offreService.AfficherMsg(id);
		
		return "Association/msgdemande";
	}
	
	@GetMapping("/Association/{id}/offres/infos/{id1}")
	public String showFormForUpdateOffre2(@PathVariable ( value = "id") long id,@PathVariable ( value = "id1") long id1, Model model) {
		Association Association = AssociationService.getAssociationById(id);
		model.addAttribute("Association", Association);
		Offre offre = offreService.getOffreById(id1);
		if(offre.getBoulangerie_id() != null) {
			model.addAttribute("offre", offre);
			return "Association/offreBoulangerie_infos";
			
		}
		if(offre.getMenage() != null) {
			model.addAttribute("offre", offre);
			return "Association/offreMenage_infos";
			
		}
		if(offre.getRestaurant() != null) {
			model.addAttribute("offre", offre);
			return "Association/offreRestaurant_infos";
			
		}
		return " h ";
	}
}
