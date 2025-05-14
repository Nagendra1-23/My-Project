package com.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.annotation.security.PermitAll;

@Configuration
public class PasswordConfig 
  {
	//to encode password
	   @Bean
	   public BCryptPasswordEncoder passwordEncoder()
	   {
		   return new BCryptPasswordEncoder();
	   }
     
	   @SuppressWarnings("removal")
	@Bean
	   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	   {
		   http.csrf().disable().authorizeHttpRequests(auth -> auth.requestMatchers("/css/register", "/js/register", "/loginemp", "/register", "/login", "/forgot-password")

			.permitAll().anyRequest().authenticated()).formLogin(form -> form.loginPage("/loginemp").loginProcessingUrl("/login")
			.defaultSuccessUrl("/dashboard", true).permitAll()).logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/loginemp") );
	   
		   return http.build();
	   }
	   
   }
