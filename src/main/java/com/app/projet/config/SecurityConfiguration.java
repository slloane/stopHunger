package com.app.projet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.app.projet.service.UtilisateurService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	 @Lazy
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	AuthenticationSuccessHandler successHandler;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	 
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(utilisateurService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        auth.inMemoryAuthentication()
		.withUser("association").password("{noop}password").roles("Association")
		.and()
		.withUser("boulangerie").password("{noop}password").roles("Boulangerie")
		.and()
		.withUser("restaurant").password("{noop}password").roles("Restaurant")
		.and()
		.withUser("menage").password("{noop}password").roles("Menage");
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				 "/registration**",
	                "/js/**",
	                "/home/**",
	                "/css/**",
	                "/**",
	                "/img/**").permitAll()
		.antMatchers("/association").hasRole("Association")
        .antMatchers("/boulangerie").hasRole("Boulangerie")
        .antMatchers("/restaurant").hasRole("Restaurant")
        .antMatchers("/menage").hasRole("Menage")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successHandler(successHandler)
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web
				.ignoring()
				.antMatchers("/ressources/**","/static/style.css/**", "/images/**","/css/**");
	}

}
