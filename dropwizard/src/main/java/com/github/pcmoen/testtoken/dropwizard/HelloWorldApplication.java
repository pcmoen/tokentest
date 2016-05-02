package com.github.pcmoen.testtoken.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthFilter;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class HelloWorldApplication extends Application<TestTokenConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "test-token";
    }

    @Override
    public void initialize(Bootstrap<TestTokenConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TestTokenConfiguration configuration,
                    Environment environment) {
        environment.jersey().register(new HelloWorldResource()  );

        AuthFilter oauthCredentialAuthFilter = new OAuthCredentialAuthFilter.Builder<TokenPrincipal>()
                .setAuthenticator(new TokenAuthenticator())
                .setAuthorizer(new TokenAuthorizer())
                .setPrefix("Token")
                .buildAuthFilter();
        environment.jersey().register(new AuthDynamicFeature(oauthCredentialAuthFilter));
        environment.jersey().register(RolesAllowedDynamicFeature.class);


        // nothing to do yet
    }

}