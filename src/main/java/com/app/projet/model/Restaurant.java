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
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "Email_utilisateur")
	String Email;
	
	@Column(name = "password")
	String Password;
	
	@Column(name = "Categorie_compte")
	String CategorieCmpte;
	
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
	private int points;
	
	@Column(name = "classement")
	private int classement;
	
	@OneToMany(
            mappedBy = "Restaurant",
            orphanRemoval = true
        )
	public List<Offre> Offres = new ArrayList<Offre>();
	
	public List<Offre> getOffres() {
		return Offres;
	}

	public void setOffres(List<Offre> offres) {
		Offres = offres;
	}

	public void addOffre(Offre offre) {
        Offres.add(offre);
        offre.setRestaurant(this);
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

	public String getCategorieCmpte() {
		return CategorieCmpte;
	}

	public void setCategorieCmpte(String categorieCmpte) {
		CategorieCmpte = categorieCmpte;
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

	public Restaurant(Long id, String email, String password, String categorieCmpte, String nomUtilisateur,
			String ville, String adresse, String bio, String contactResponsable, int points, int classement) {
		super();
		this.id = id;
		Email = email;
		Password = password;
		CategorieCmpte = categorieCmpte;
		this.nomUtilisateur = nomUtilisateur;
		Ville = ville;
		this.adresse = adresse;
		this.bio = bio;
		this.contactResponsable = contactResponsable;
		this.points = points;
		this.classement = classement;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
