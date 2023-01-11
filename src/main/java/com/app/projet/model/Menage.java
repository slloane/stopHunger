package com.app.projet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menage")
public class Menage{

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
	
	@Column(name = "cin")
	String cin;

	@OneToMany(
            mappedBy = "Menage",
            orphanRemoval = true
        )
	public List<Offre> Offres = new ArrayList<Offre>();
	
	public void addOffre(Offre offre) {
        Offres.add(offre);
        offre.setMenage(this);
    }
	
	public List<Offre> getOffres() {
		return Offres;
	}

	public void setOffres(List<Offre> offres) {
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Menage(Long id, String email, String password, String nomUtilisateur, String ville, String adresse,
			String bio, String cin) {
		super();
		this.id = id;
		Email = email;
		Password = password;
		this.nomUtilisateur = nomUtilisateur;
		Ville = ville;
		this.adresse = adresse;
		this.bio = bio;
		this.cin = cin;
	}

	public Menage() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
