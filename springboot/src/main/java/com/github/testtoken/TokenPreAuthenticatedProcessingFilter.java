package com.github.pcmoen.tokentest.springmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pcmoen
 */
public class TokenPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {
	private static final String prefix = "Token";

	@Override
	protected Object getPreAuthenticatedPrincipal(final HttpServletRequest request) {
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (header != null) {
			final int space = header.indexOf(" ");
			if (space >= 0 && prefix.equalsIgnoreCase(header.substring(0, space))) {
				return header.substring(space +1);
			}
		}
		return null;
	}

	@Override
	protected Object getPreAuthenticatedCredentials(final HttpServletRequest request) {
		return null;
	}
}
