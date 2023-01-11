package com.app.projet.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.projet.model.Restaurant;
import com.app.projet.model.Association;
import com.app.projet.model.Offre;
import com.app.projet.service.RestaurantService;
import com.app.projet.service.OffreService;

@Controller
public class OffreRestaurantController {
	
	@Autowired
    private OffreService offreService;
	@Autowired
	private RestaurantService RestaurantService;
	
	
	@GetMapping("/Restaurant/{id}/listOffre")
    public String viewHomePage3(@PathVariable(value = "id") Long id, Model model) {
		Restaurant Restaurant = RestaurantService.getRestaurantById(id);
		model.addAttribute("ListOffres", Restaurant.Offres);
		model.addAttribute("Restaurant", Restaurant);
		return "Restaurant/listeOffre";
	}
	
	
	@GetMapping("/Restaurant/{id}/showNewOffreForm")
	public String showNewOffreForm( @PathVariable(value = "id") Long id, Model model) {
		Restaurant Restaurant = RestaurantService.getRestaurantById(id);
		model.addAttribute("Restaurant", Restaurant);
		Offre offre=new Offre();
		model.addAttribute("offre", offre);
		return "Restaurant/new_offre";
	}
	
	@PostMapping("/Restaurant/{id}/saveOffre")
	public String saveOffre(@PathVariable(value = "id") Long id,@ModelAttribute("offre") Offre offre ) {
		Restaurant Restaurant= RestaurantService.getRestaurantById(id);
		Restaurant.addOffre(offre);
		Restaurant.setPoints(Restaurant.Offres.size());
		offreService.saveOffre(offre);
		return "redirect:/Restaurant/{id}/listOffre";
	}
	
	@GetMapping("/Restaurant/{id}/showFormForUpdateOffre/{id2}")
	public String showFormForUpdateOffre(@PathVariable ( value = "id") long id, Model model, @PathVariable (value = "id2") long id2) {
		Offre offre = offreService.getOffreById(id2);
		Restaurant Restaurant= RestaurantService.getRestaurantById(id);
		model.addAttribute("offre", offre);
		model.addAttribute("Restaurant", Restaurant);
		return "Restaurant/update_offre";
	}
	
	
	@GetMapping("/Restaurant/{id}/deleteOffre/{id2}")
	public String deleteOffre(@PathVariable (value = "id") long id, @PathVariable (value = "id2") long id2) {
		Set<Association> a = offreService.getOffreById(id2).Associations;
		for (Association asso: a) {
			asso.Offres.clear();
		}
		offreService.getOffreById(id2).Associations.clear();
		this.offreService.deleteOffreById(id2);
		
		return "redirect:/Restaurant/{id}/listOffre";
	}
	
	@GetMapping("/Restaurant/{id}/demandeOffre/{id1}")
	public String DemandeOffre(@PathVariable ( value = "id") long id,@PathVariable ( value = "id1") long id1, Model model) {
		Offre offre = offreService.getOffreById(id1);
		model.addAttribute("offre", offre);
		Restaurant Restaurant= RestaurantService.getRestaurantById(id);
		model.addAttribute("Restaurant", Restaurant);
		return "Restaurant/Demande_infos";
	}
	
	@GetMapping("/Restaurant/demande/{id}")
	public String demanderOffre(@PathVariable (value = "id") long id) {
		
		this.offreService.AfficherMsg(id);
		
		return "msgdemande";
	}
}
