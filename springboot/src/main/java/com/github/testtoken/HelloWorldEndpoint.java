package com.github.testtoken;

import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class HelloWorldEndpoint {
    @GET
    @Path("/world")
    @RolesAllowed("ROLE_LES")
    public String test() {
        return "Hello world!";
    }
}