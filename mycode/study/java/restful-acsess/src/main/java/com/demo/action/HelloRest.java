package com.demo.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloRest{

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    //访问路径 /hello/zhaochao
    public String hello(@PathParam("name") String name) throws Exception {
        return "hello wolrd! "+name;
    }
}
