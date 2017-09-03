package com.demo.action;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class WorldTest {

    @GET
    @Path("helloworld")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() throws Exception {
        return "hello wolrd! ";
    }
}
