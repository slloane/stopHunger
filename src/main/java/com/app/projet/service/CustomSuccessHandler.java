package com.app.projet.service;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.app.projet.model.Boulangerie;
import com.app.projet.model.Utilisateur;
import com.app.projet.repository.BoulangerieRepository;
import com.app.projet.repository.AssociationRepository;
import com.app.projet.repository.RestaurantRepository;
import com.app.projet.repository.MenageRepository;
import com.app.projet.model.Association;
import com.app.projet.model.Restaurant;
import com.app.projet.model.Menage;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{
	@Autowired
	private BoulangerieService BoulangerieService;
	@Autowired
	private AssociationService AssociationService;
	@Autowired
	private RestaurantService RestaurantService;
	@Autowired
	private MenageService MenageService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
		String redirectUrl = null;
		

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("role " + grantedAuthority.getAuthority());
			if (grantedAuthority.getAuthority().equals("Association")) {
				String s=authentication.getName();
				Association b = AssociationService.FindByEmail(s);
				long l = b.getId();
				redirectUrl = "/Association/"+l;
				break;
			} else if (grantedAuthority.getAuthority().equals("Boulangerie")) {
				String s=authentication.getName();
				Boulangerie b = BoulangerieService.FindByEmail(s);
				long l = b.getId();
				redirectUrl = "/Boulangerie/"+l;
				break;
			}else if (grantedAuthority.getAuthority().equals("Restaurant")) {
				String s=authentication.getName();
				Restaurant b = RestaurantService.FindByEmail(s);
				long l = b.getId();
				redirectUrl = "/Restaurant/"+l;
				break;
			}else if (grantedAuthority.getAuthority().equals("Menage")) {
				String s=authentication.getName();
				Menage b = MenageService.FindByEmail(s);
				long l = b.getId();
				redirectUrl = "/Menage/"+l;
				break;
			}
		}
		System.out.println("redirectUrl " + redirectUrl);
		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}
