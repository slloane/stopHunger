package com.app.projet.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "AppelsAuxDons")

public class AppelsAuxDons {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String objectif;
	private double montant_cible;
	private String description;
	private String statut;
	private String gens_cible;
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Association association;
	 
	  
	  public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}
	public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getObjectif() {
			return objectif;
		}
		public void setObjectif(String objectif) {
			this.objectif = objectif;
		}
		public double getMontant_cible() {
			return montant_cible;
		}
		public void setMontant_cible(double montant_cible) {
			this.montant_cible = montant_cible;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getStatut() {
			return statut;
		}
		public void setStatut(String statut) {
			this.statut = statut;
		}
		public String getGens_cible() {
			return gens_cible;
		}
		public void setGens_cible(String gens_cible) {
			this.gens_cible = gens_cible;
		}
		@Override
		public String toString() {
			return "AppelsAuxDons [id=" + id + ", objectif=" + objectif + ", montant_cible=" + montant_cible
					+ ", description=" + description + ", statut=" + statut + ", gens_cible=" + gens_cible + "]";
		}
		public AppelsAuxDons(long id, String objectif, double montant_cible, String description, String statut,
				String gens_cible) {
			super();
			this.id = id;
			this.objectif = objectif;
			this.montant_cible = montant_cible;
			this.description = description;
			this.statut = statut;
			this.gens_cible = gens_cible;
		}
		public AppelsAuxDons() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
