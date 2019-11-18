package com.efficaxbs.myreports.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	  @Override 
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication().withUser("saikiran").password("password").roles("ADMIN");
			auth.inMemoryAuthentication().withUser("kiransai").password("saikiran").roles("USER");
	  }   	
	  @Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/MyReports/**").hasRole("USER")
			.antMatchers(HttpMethod.POST, "/MyReports").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/MyReports/**").hasRole("ADMIN")   
            .antMatchers(HttpMethod.DELETE, "/MyReports/**").hasRole("ADMIN") 	
			.anyRequest().fullyAuthenticated().and()
			.httpBasic();
		}  
	  @Bean
		public static NoOpPasswordEncoder passwordEncoder() {
			return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
		}   
}     