package com.github.testtoken;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Collections;

/**
 * @author pcmoen
 */
public class TokenAuthenticationManager implements AuthenticationManager {
	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		return new PreAuthenticatedAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + authentication.getPrincipal().toString().toUpperCase())));
	}
}
