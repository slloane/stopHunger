package com.app.projet.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "association")
public class Association{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "Email_utilisateur")
	String Email;
	
	@Column(name = "password")
	String Password;
	
	@Column(name = "Nom_utilisateur")
	String nomUtilisateur;
	
	@Column(name = "Ville")
	String Ville;
	
	@Column(name = "adresse")
	String adresse;
	
	@Column(name = "bio")
	String bio;
	
	@Column(name = "contact_Responsable")
	private String contactResponsable;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  public Set<Offre> Offres = new HashSet<Offre>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "association")
	public List<Besoin> listeBesoins=new ArrayList<Besoin>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "association")
	public List<AppelsAuxDons> listeAppels=new ArrayList<AppelsAuxDons>();

	public void addBesoin(Besoin besoin) {
        listeBesoins.add(besoin);
        besoin.setAssociation(this);
    }
	
	public void addAppel(AppelsAuxDons appel) {
        listeAppels.add(appel);
        appel.setAssociation(this);
    }
	
	public List<Besoin> getListeBesoins() {
		return listeBesoins;
	}

	public void setListeBesoins(List<Besoin> listeBesoins) {
		this.listeBesoins = listeBesoins;
	}

	public List<AppelsAuxDons> getListeAppels() {
		return listeAppels;
	}

	public void setListeAppels(List<AppelsAuxDons> listeAppels) {
		this.listeAppels = listeAppels;
	}

	public Set<Offre> getOffres() {
		return Offres;
	}

	public void setOffres(Set<Offre> offres) {
		Offres = offres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getContactResponsable() {
		return contactResponsable;
	}

	public void setContactResponsable(String contactResponsable) {
		this.contactResponsable = contactResponsable;
	}

	public Association(Long id, String email, String password, String categorieCmpte, String nomUtilisateur,
			String ville, String adresse, String bio, String contactResponsable) {
		super();
		this.id = id;
		Email = email;
		Password = password;
		this.nomUtilisateur = nomUtilisateur;
		Ville = ville;
		this.adresse = adresse;
		this.bio = bio;
		this.contactResponsable = contactResponsable;
	}

	public Association() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
}
