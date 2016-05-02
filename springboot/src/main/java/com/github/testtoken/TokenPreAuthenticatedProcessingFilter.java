package com.github.testtoken;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

/**
 * @author pcmoen
 */
public class TokenPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {
	@Override
	protected Object getPreAuthenticatedPrincipal(final HttpServletRequest request) {
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		return header;
	}

	@Override
	protected Object getPreAuthenticatedCredentials(final HttpServletRequest request) {
		return null;
	}
}
