package com.github.pcmoen.testtoken.dropwizard;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

/**
 * @author pcmoen
 */
public class TokenPrincipal implements Principal {
	private String name;
	private Set<String> roles = new HashSet<String>();

	public TokenPrincipal(final String token, final Set<String> roles) {
		this.name = token;
		this.roles.addAll(roles);
	}

	public String getName() {
		return name;
	}

	public boolean isInRole(final String role) {
		return roles.contains(role);
	}
}
