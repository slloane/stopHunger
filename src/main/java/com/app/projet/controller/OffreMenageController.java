package com.app.projet.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.projet.model.Offre;
import com.app.projet.model.Association;
import com.app.projet.model.Menage;
import com.app.projet.service.OffreService;
import com.app.projet.service.MenageService;

@Controller
public class OffreMenageController {
	
	@Autowired
    private OffreService offreService;
	@Autowired
	private MenageService MenageService;
	
	
	@GetMapping("/Menage/{id}/listOffre")
    public String viewHomePage3(@PathVariable(value = "id") Long id, Model model) {
		Menage Menage = MenageService.getMenageById(id);
		model.addAttribute("ListOffres", Menage.Offres);
		model.addAttribute("Menage", Menage);
		return "Menage/listeOffre";
	}
	
	
	@GetMapping("/Menage/{id}/showNewOffreForm")
	public String showNewOffreForm( @PathVariable(value = "id") Long id, Model model) {
		Menage Menage = MenageService.getMenageById(id);
		model.addAttribute("Menage", Menage);
		Offre offre=new Offre();
		model.addAttribute("offre", offre);
		return "Menage/new_offre";
	}
	
	@PostMapping("/Menage/{id}/saveOffre")
	public String saveOffre(@PathVariable(value = "id") Long id,@ModelAttribute("offre") Offre offre, Model model ) {
		Menage Menage = MenageService.getMenageById(id);
		Menage.addOffre(offre);
		offreService.saveOffre(offre);
		
		model.addAttribute("Menage", Menage);
		return "redirect:/Menage/{id}/listOffre";
	}
	
	@GetMapping("/Menage/{id}/showFormForUpdateOffre/{id2}")
	public String showFormForUpdateOffre(@PathVariable ( value = "id") long id, Model model, @PathVariable (value = "id2") long id2) {
		Offre offre = offreService.getOffreById(id2);
		Menage Menage = MenageService.getMenageById(id);
		model.addAttribute("offre", offre);
		model.addAttribute("Menage", Menage);
		return "Menage/update_offre";
	}
	
	
	@GetMapping("/Menage/{id}/deleteOffre/{id2}")
	public String deleteOffre(@PathVariable (value = "id") long id, @PathVariable (value = "id2") long id2, Model model) {
		Set<Association> a = offreService.getOffreById(id2).Associations;
		for (Association asso: a) {
			asso.Offres.clear();
		}
		offreService.getOffreById(id2).Associations.clear();
		this.offreService.deleteOffreById(id2);
		Menage Menage = MenageService.getMenageById(id);
		
		model.addAttribute("Menage", Menage);
		
		return "redirect:/Menage/{id}/listOffre";
	}
	
	@GetMapping("/Menage/{id}/demandeOffre/{id1}")
	public String DemandeOffre(@PathVariable ( value = "id") long id,@PathVariable ( value = "id1") long id1, Model model) {
		Offre offre = offreService.getOffreById(id1);
		model.addAttribute("offre", offre);
		Menage Menage = MenageService.getMenageById(id);
		model.addAttribute("Menage", Menage);
		return "Menage/Demande_infos";
	}
	
	@GetMapping("/Menage/demande/{id}")
	public String demanderOffre(@PathVariable (value = "id") long id) {
		
		this.offreService.AfficherMsg(id);
		
		return "msgdemande";
	}
}
