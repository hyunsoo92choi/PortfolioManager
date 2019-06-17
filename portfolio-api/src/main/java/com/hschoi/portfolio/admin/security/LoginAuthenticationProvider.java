package com.hschoi.portfolio.admin.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hschoi.portfolio.admin.entity.AdminEntity;
import com.hschoi.portfolio.admin.service.AdminService;

/**
 * <pre>
 * com.hschoi.portfolio.admin.security_LoginAuthenticationProvider.java
 * </pre>
 * @date : 2019. 6. 17.
 * @author : hychoi
 */
@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
	
	private final AdminService adminService;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public LoginAuthenticationProvider(AdminService adminService
					, BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.adminService = adminService;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String email = authentication.getName();		
		String password = (String)authentication.getCredentials();
		
		AdminEntity admin = adminService.readByEmail(email);
		
		String dbPassword = admin.getAdminPassword();
		
		if(!bcryptPasswordEncoder.matches(password, dbPassword)) {
			
			throw new BadCredentialsException("Invaild Password");
			
		}
		
		return new UsernamePasswordAuthenticationToken(admin, dbPassword, admin.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
