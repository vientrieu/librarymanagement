package com.example.librarymanagement.config.security;

import com.example.librarymanagement.config.filter.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author mangvientrieu
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private JWTFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
				.addFilterBefore(jwtFilter, BasicAuthenticationFilter.class)
				.httpBasic();
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/auth/**", "/kafka/**");
	}

}
