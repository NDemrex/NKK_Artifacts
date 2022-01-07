package com.gcu.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

protected void configuration(HttpSecurity http) throws Exception{
		
		http
		.authorizeRequests()
		//LETS RESTRICT WHO CAN SEE, THE MAPPING FOLLOWING CONTROLLER FOR PAGES
		.antMatchers("/Artifacts/ArtifactAdmin").hasRole("ADMIN")
		.antMatchers("/Artifacts/AddNewArtifact").hasAnyRole("ADMIN", "MANAGER")
		
		//Allow REST
		.antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("ADMIN","MANAGER")
		.antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("ADMIN","MANAGER")
		.antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("ADMIN")
		.antMatchers("/api/**").authenticated()
		
		//NON USERS GO TO LOGIN and check google
		.antMatchers("/Login/", "/img/**").permitAll()
		.and()
		.httpBasic()
		.and()
		//call the login form I made and not the Spring standard. check here
		.formLogin()
		.loginPage("/Login/")
		//check the user inputs to the form, we want the USERNAME and PASSWORD
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll()
		//ONCE WE LOGIN SUCCESSFULLY WE NEED TO SEND THEM TO THE  ARTIFACTS PAGE 
		.defaultSuccessUrl("/Artifacts/all")
		.and()
		
		//LOGOUT
		.logout()
		.logoutUrl("/logout")
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.permitAll()
		
		//WE CAN ALSO SET A CONTROLLER FOR THE LOGOUT IF WE WANT TO IMPLEMENT THIS
		.logoutSuccessUrl("/Login/")
		.and()
		.csrf().ignoringAntMatchers("/api/**");
		
	}
	
	//CONFIGURE LOGINS FOR ADMIN, MANAGER, AND USER
	
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		
			
			//THE BOSS	
					.withUser("demrex")
					.password("password").roles("ADMIN", "MANAGER").and()
						//MANAGER SIGN IN
					.withUser("shad").password("123")
					.roles("MANAGER", "USER").and()
						//STANDARD USER
					.withUser("user1")
					.password("456").roles("USER");
			
		}
	
}
