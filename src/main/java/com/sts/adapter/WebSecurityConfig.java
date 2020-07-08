package com.sts.adapter;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String[] AUTH_WHITELIST = {
		//SWAGGER UI
		"/swagger-ui.html",
		"/swagger-resources/**",
		"/webjars/**",
		"/v2/api-docs"
		//OTHER PUBLIC ENDPOINTS 
	};
	
	@Resource(name="userService")
	private UserDetailsService userDetailsService;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	@Autowired
	protected void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
	
	@Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

	 @Bean
	 public TokenStore tokenStore() {
		 return new InMemoryTokenStore();
	 }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.anonymous().disable()
			.authorizeRequests()
			.antMatchers(AUTH_WHITELIST).permitAll();					
	}
}
