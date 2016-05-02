package com.github.pcmoen.testtoken.dropwizard;

/**
 * @author pcmoen
 */
public class TokenAuthorizer implements io.dropwizard.auth.Authorizer<TokenPrincipal> {
	public boolean authorize(final TokenPrincipal principal, final String role) {
		return principal.isInRole(role);
	}
}
