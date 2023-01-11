package com.app.projet.controller.dto;

public class UserRegistrationDto {
	private String email;
	private String Password;
	private String nomUtilisateur;
	private String Ville;
	private String adresse;
	private String bio;
	private String CategorieCmpte;
	
	public UserRegistrationDto(){
		
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

	public String getCategorieCmpte() {
		return CategorieCmpte;
	}

	public void setCategorieCmpte(String categorieCmpte) {
		CategorieCmpte = categorieCmpte;
	}

	public UserRegistrationDto(String email, String password, String ville,String adresse,String bio,String nomUtilisateur,String categorieCmpte) {
		super();
		this.email = email;
		Password = password;
		this.nomUtilisateur = nomUtilisateur;
		Ville = ville;
		this.adresse = adresse;
		this.bio = bio;
		CategorieCmpte = categorieCmpte;
	}

	
	
	
}
