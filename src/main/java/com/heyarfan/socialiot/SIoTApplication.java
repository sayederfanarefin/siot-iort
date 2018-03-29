package com.heyarfan.socialiot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SIoTApplication {

	
	@Autowired
    UserDetailsService userDetailsService;
	
	
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
    	
        builder.userDetailsService(userDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    
	public static void main(String[] args) {
		SpringApplication.run(SIoTApplication.class, args);
	}
}



