package com.hschoi.common.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hschoi.common.security.LoginAuthenticationProvider;

/**
 * <pre>
 * security.config_SecurityConfig.java
 * </pre>
 * @date : 2019. 6. 11.
 * @author : hychoi
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private LoginAuthenticationProvider loginAuthenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
			.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).maximumSessions(1)
		.and().and()
		.authorizeRequests() 
			.antMatchers("/**", "/api/login", "/api/sign").permitAll()
			.antMatchers("/api/config").hasAuthority("ROLE_ADMIN")
			.anyRequest().authenticated()
			.and()
		.logout();
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				.antMatchers("/css/**", 
						"/fonts/**",
						"/image/**",
						"/js/**",
						"/vendores/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(loginAuthenticationProvider);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoderBean() throws Exception{
		return new BCryptPasswordEncoder();
	}
}
