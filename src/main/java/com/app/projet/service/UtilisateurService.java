package com.app.projet.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.projet.model.Utilisateur;
import com.app.projet.controller.dto.UserRegistrationDto;

public interface UtilisateurService extends UserDetailsService{
	Utilisateur save(UserRegistrationDto registrationDto);
}
