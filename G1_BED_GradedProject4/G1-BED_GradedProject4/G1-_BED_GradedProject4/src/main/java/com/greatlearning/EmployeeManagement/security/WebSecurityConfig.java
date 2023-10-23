package com.greatlearning.EmployeeManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.EmployeeManagement.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder ();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
			
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/roles/list", "/roles/add", "/roles/save").permitAll()
		.antMatchers("/users/add", "/users/save").permitAll()
		.antMatchers("/employees/list", "/employees/save", "/employees/update", "/employees/view", "/employees/403").hasAnyAuthority("USER", "ADMIN")
		.antMatchers("/employees/add", "/employees/delete").hasAnyAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/employees/list")
		.and()
		.logout().logoutSuccessUrl("/")
		.and()
		.exceptionHandling().accessDeniedPage("/employees/403")
		.and()
		.cors().and().csrf().disable();
	}
}
