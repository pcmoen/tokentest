package com.github.pcmoen.testtoken.dropwizard;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;

import java.util.Collections;

/**
 * @author pcmoen
 */
public class TokenAuthenticator implements io.dropwizard.auth.Authenticator<String, TokenPrincipal> {
	public Optional<TokenPrincipal> authenticate(final String token) throws AuthenticationException {
		return Optional.of(new TokenPrincipal(token, Collections.singleton("ROLE_" + token.toUpperCase())));
	}
}
