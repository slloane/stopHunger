package com.app.projet.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.projet.model.Role;
import com.app.projet.model.Utilisateur;
import com.app.projet.repository.UtilisateurRepository;
import com.app.projet.controller.dto.UserRegistrationDto;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	private UtilisateurRepository utlisateurRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UtilisateurServiceImpl(UtilisateurRepository utlisateurRepository) {
		super();
		this.utlisateurRepository = utlisateurRepository;
	}

	@Override
	public Utilisateur save(UserRegistrationDto registrationDto) {
		Utilisateur utilisateur = new Utilisateur(registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()), 
				 registrationDto.getVille(),registrationDto.getAdresse(), registrationDto.getBio(),registrationDto.getNomUtilisateur(),registrationDto.getCategorieCmpte() ,Arrays.asList(new Role(registrationDto.getCategorieCmpte())));
		
		return utlisateurRepository.save(utilisateur);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Utilisateur utilisateur = utlisateurRepository.findByEmail(username);
		if(utilisateur == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(utilisateur.getEmail(), utilisateur.getPassword(), mapRolesToAuthorities(utilisateur.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	
	
}
