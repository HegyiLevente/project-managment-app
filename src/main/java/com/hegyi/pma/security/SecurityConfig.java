package com.hegyi.pma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;

	public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	protected BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected AuthenticationManager customAuthenticationManager() throws Exception{
		return authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/projects/new").hasAuthority("ADMIN")
			.antMatchers("/projects/save").hasAuthority("ADMIN")
			.antMatchers("/projects/update").hasAuthority("ADMIN")
			.antMatchers("/projects/delete").hasAuthority("ADMIN")
			.antMatchers("/employees/new").hasAuthority("ADMIN")
			.antMatchers("/employees/save").hasAuthority("ADMIN")
			.antMatchers("/employees/update").hasAuthority("ADMIN")
			.antMatchers("/employees/delete").hasAuthority("ADMIN")
			.antMatchers("/registration").permitAll()
			.antMatchers("/registration/save").permitAll()
			.antMatchers("/js/**", "/css/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
			.and()
			.logout().logoutUrl("/logout").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService).passwordEncoder(getPasswordEncoder());
	}
	
	
}



















