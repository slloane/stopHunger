package com.app.projet.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.app.projet.model.Offre;
import com.app.projet.repository.BoulangerieRepository;
import com.app.projet.repository.OffreRepository;
import com.app.projet.repository.AppelsAuxDonsRepository;
import com.app.projet.service.OffreService;
import com.app.projet.service.AppelsAuxDonsService;
import com.app.projet.service.BoulangerieService;


@Controller
public class OffreBoulangerieController {

	@Autowired
    private OffreService offreService;
	@Autowired
	private BoulangerieService BoulangerieService;
	
	
	@GetMapping("/Boulangerie/{id}/listOffre")
    public String viewHomePage3(@PathVariable(value = "id") Long id, Model model) {
		Boulangerie Boulangerie = BoulangerieService.getBoulangerieById(id);
		model.addAttribute("ListOffres", Boulangerie.Offres);
		model.addAttribute("Boulangerie", Boulangerie);
		return "Boulangerie/listeOffre";
	}
	
	
	@GetMapping("/Boulangerie/{id}/showNewOffreForm")
	public String showNewOffreForm( @PathVariable(value = "id") Long id, Model model) {
		Boulangerie Boulangerie = BoulangerieService.getBoulangerieById(id);
		model.addAttribute("Boulangerie", Boulangerie);
		Offre offre=new Offre();
		model.addAttribute("offre", offre);
		
		return "Boulangerie/new_offre";
	}
	
	@PostMapping("/Boulangerie/{id}/saveOffre")
	public String saveOffre(@PathVariable(value = "id") Long id,@ModelAttribute("offre") Offre offre , Model model) {
		Boulangerie Boulangerie= BoulangerieService.getBoulangerieById(id);
		Boulangerie.addOffre(offre);
		Boulangerie.setPoints(Boulangerie.Offres.size());
		offreService.saveOffre(offre);
		 Boulangerie b= BoulangerieService.getBoulangerieById(id);
		 model.addAttribute("Boulangerie",b);
		return "redirect:/Boulangerie/{id}/listOffre";
	}
	
	@GetMapping("/Boulangerie/{id}/showFormForUpdateOffre/{id2}")
	public String showFormForUpdateOffre(@PathVariable ( value = "id") long id, Model model, @PathVariable (value = "id2") long id2) {
		Offre offre = offreService.getOffreById(id2);
		Boulangerie Boulangerie= BoulangerieService.getBoulangerieById(id);
		model.addAttribute("offre", offre);
		model.addAttribute("Boulangerie", Boulangerie);
		return "Boulangerie/update_offre";
	}
	
	
	@GetMapping("/Boulangerie/{id}/deleteOffre/{id2}")
	public String deleteOffre(@PathVariable (value = "id") long id, @PathVariable (value = "id2") long id2) {
		Set<Association> a = offreService.getOffreById(id2).Associations;
		for (Association asso: a) {
			asso.Offres.clear();
		}
		offreService.getOffreById(id2).Associations.clear();
		this.offreService.deleteOffreById(id2);
		
		return "redirect:/Boulangerie/{id}/listOffre";
	}
	
	@GetMapping("/Boulangerie/{id}/demandeOffre/{id1}")
	public String DemandeOffre(@PathVariable ( value = "id") long id,@PathVariable ( value = "id1") long id1, Model model) {
		Offre offre = offreService.getOffreById(id1);
		model.addAttribute("offre", offre);
		Boulangerie Boulangerie= BoulangerieService.getBoulangerieById(id);
		model.addAttribute("Boulangerie", Boulangerie);
		return "Boulangerie/Demande_infos";
	}
	
	@GetMapping("/Boulangerie/demande/{id}")
	public String demanderOffre(@PathVariable (value = "id") long id) {
		
		this.offreService.AfficherMsg(id);
		
		return "msgdemande";
	}
	
	
}
