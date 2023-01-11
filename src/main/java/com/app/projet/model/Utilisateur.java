package com.app.projet.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.app.projet.model.Role;


@Entity
@Table(name =  "Utilisateur", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "email")
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
	
	@Column(name = "Categorie_compte")
	String CategorieCmpte;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	
	
	private Collection<Role> roles;
	

	
	public Utilisateur() {
		
	}
	
	
	


	public Utilisateur(String email, String password, String ville,String adresse,String bio,String nomUtilisateur,String categorieCmpte, Collection<Role> roles) {
		super();
		this.email = email;
		Password = password;
		CategorieCmpte = categorieCmpte;
		this.nomUtilisateur = nomUtilisateur;
		Ville = ville;
		this.adresse = adresse;
		this.bio = bio;
		this.roles = roles;
	}


	





	public Utilisateur(String email, String password, String ville, String adresse, String bio,String nomUtilisateur) {
		super();
		this.email = email;
		Password = password;
		this.nomUtilisateur = nomUtilisateur;
		Ville = ville;
		this.adresse = adresse;
		this.bio = bio;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		email = email;
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

	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}