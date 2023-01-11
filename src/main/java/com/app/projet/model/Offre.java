package com.app.projet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.app.projet.model.Boulangerie.*;

@Entity
@Table(name = "offre")
public class Offre{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String Quantite;
	private String type;
	  
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_Expiration;
	private String Etat;
	  
	@ManyToOne(fetch = FetchType.LAZY)
	public Boulangerie Boulangerie_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Menage Menage;
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Restaurant Restaurant;
	
	public Menage getMenage() {
		return Menage;
	}

	public void setMenage(Menage menage) {
		Menage = menage;
	}

	public Restaurant getRestaurant() {
		return Restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		Restaurant = restaurant;
	}
	@ManyToMany(fetch = FetchType.LAZY)
	  public Set<Association> Associations = new HashSet<Association>();
	
	public void addAssociation(Association Association) {
		Associations.add(Association);
        Association.Offres.add(this);
    }

	public Set<Association> getAssociations() {
		return Associations;
	}
	public void setAssociations(Set<Association> associations) {
		Associations = associations;
	}
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "association_id")
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  public Association Association;
	  
	public Association getAssociation() {
		return Association;
	}
	public void setAssociation(Association association) {
		Association = association;
	}*/
	public Boulangerie getBoulangerie_id() {
		return Boulangerie_id;
	}
	public void setBoulangerie_id(Boulangerie boulangerie) {
		Boulangerie_id = boulangerie;
	}
	/*  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "boulangerie_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Boulangerie Boulangerie;
	  
	public Boulangerie getBoulangerie() {
		return Boulangerie;
	}
	public void setBoulangerie(Boulangerie boulangerie) {
		Boulangerie = boulangerie;
	}*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuantite() {
		return Quantite;
	}
	public void setQuantite(String quantite) {
		Quantite = quantite;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate_Expiration() {
		return date_Expiration;
	}
	public void setDate_Expiration(Date date_Expiration) {
		this.date_Expiration = date_Expiration;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	@Override
	public String toString() {
		return "Offre [id=" + id + ", Quantite=" + Quantite + ", type=" + type + ", date_Expiration=" + date_Expiration
				+ ", Etat=" + Etat + "]";
	}
	public Offre(long id, String quantite, String type, Date date_Expiration, String etat) {
		super();
		this.id = id;
		Quantite = quantite;
		this.type = type;
		this.date_Expiration = date_Expiration;
		Etat = etat;
	}
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
	  
	  
	  
}
