package com.codingdojo.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;
	
	public WebSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.
//			Allows restricting access based upon the HttpServletRequest
			authorizeRequests()
//				PathMatcher implementation for Ant-style path patterns. ** matches zero or more directories in a path
				.antMatchers("/css/**", "/js/**", "/registration").permitAll()
//				Maps any request and Specify URLs that are allowed by authenticated users only
				.anyRequest().authenticated()
				.and()
//			Specifies to support form based authentication. Now, our users are going to be authenticated via a FORM
			.formLogin()
//				Specifies the URL to send users to if login is required
				.loginPage("/login")
				.permitAll()
				.and()
//			Provides logout support. The default is that accessing the URL "/logout" will log the user out by invalidating the HTTP Session,cleaning up any rememberMe() authentication that was configured, clearing the SecurityContextHolder, and then redirect to "/login?success".
			.logout()
				.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
}
