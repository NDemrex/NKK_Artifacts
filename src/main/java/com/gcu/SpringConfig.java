package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.gcu.business.SecurityServiceInterface;
import com.gcu.business.ValidLogins;

@Configuration
public class SpringConfig {
	
	@Bean(name = "securityService")
	public SecurityServiceInterface getSecurityService() {
		return new ValidLogins();
	}	
}