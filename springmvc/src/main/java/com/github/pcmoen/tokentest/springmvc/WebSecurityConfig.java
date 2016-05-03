package com.github.pcmoen.tokentest.springmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		TokenPreAuthenticatedProcessingFilter filter = new TokenPreAuthenticatedProcessingFilter();
		filter.setAuthenticationManager(authenticationManager());
		http.addFilterAfter(filter, SecurityContextPersistenceFilter.class);
//		http.addFilterAfter(filter, ExceptionTranslationFilter.class);
//		http.authorizeRequests().anyRequest().permitAll();
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return new TokenAuthenticationManager();
	}

	/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProvider() {
	        @Override
	        public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		        return null;
	        }

	        @Override
	        public boolean supports(final Class<?> authentication) {
		        return false;
	        }
        });
    }
	*/
}