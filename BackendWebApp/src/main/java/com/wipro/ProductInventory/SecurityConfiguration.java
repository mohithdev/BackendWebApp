package com.wipro.ProductInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userdetails;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*//set your configuration on the auth object
		//first set the type of authentication that you want
		auth.inMemoryAuthentication()
			.withUser("mohith")
			.password("mohith")
			.roles("USER")
			.and()
			.withUser("nikhil")
			.password("nikhil")
			.roles("ADMIN");*/
		auth.userDetailsService(userdetails);
		
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin").hasRole("ADMIN") 
				//the order here should be highly restrictive to less restrictive
				.antMatchers("/user").hasAnyRole("USER", "ADMIN")
				.antMatchers("/products").permitAll()
				.and()
				.formLogin();
				/*.antMatchers("/").permitAll()
				.antMatchers("/**")
				.hasRole("ADMIN")
				.and()
				.formLogin();*/
	}
}
