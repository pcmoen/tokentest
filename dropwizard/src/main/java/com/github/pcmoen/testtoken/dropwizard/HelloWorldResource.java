package com.github.pcmoen.testtoken.dropwizard;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorldResource {
    @GET
    @Path("/world")
    @RolesAllowed("ROLE_LES")
    public String test() {
        return "Hello world!";
    }
    @GET
    @Path("/world2")
    @RolesAllowed("ROLE_KJELL")
    public String test2() {
        return "Hello world2!";
    }
}