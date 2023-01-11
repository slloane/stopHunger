package com.app.projet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "boulangerie")
public class Boulangerie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Email_utilisateur")
	String email;
	
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
	
	@Column(name = "points")
	private int points ;	
	@Column(name = "classement")
	private int classement;
	
	/*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Offre> Offres;*/
	@OneToMany(
            mappedBy = "Boulangerie_id",
            orphanRemoval = true
        )
	public List<Offre> Offres = new ArrayList<Offre>();
	
	public void addOffre(Offre offre) {
        Offres.add(offre);
        offre.setBoulangerie_id(this);
    }

   /* public void removeOffre(Offre offre) {
        Offres.remove(offre);
        offre.setBoulangerie_id(null);
    }*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getClassement() {
		return classement;
	}

	public void setClassement(int classement) {
		this.classement = classement;
	}

	public Boulangerie(long id, String email, String password, String nomUtilisateur, String ville, String adresse,
			String bio, String contactResponsable, int points, int classement) {
		super();
		this.id = id;
		email = email;
		Password = password;
		this.nomUtilisateur = nomUtilisateur;
		Ville = ville;
		this.adresse = adresse;
		this.bio = bio;
		this.contactResponsable = contactResponsable;
		this.points = points;
		this.classement = classement;
	}

	public Boulangerie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	



}
