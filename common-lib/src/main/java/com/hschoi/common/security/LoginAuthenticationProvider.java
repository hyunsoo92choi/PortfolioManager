package com.hschoi.common.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * security_LoginAuthenticationProvider.java
 * </pre>
 * @date : 2019. 6. 11.
 * @author : hychoi
 */
@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String email = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}
