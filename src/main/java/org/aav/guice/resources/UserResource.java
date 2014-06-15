package org.aav.guice.resources;

import com.google.inject.servlet.RequestScoped;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by aurel.avramescu on 14/06/2014.
 */
@Path("/users")
@RequestScoped
public class UserResource {


    @GET
    public Response getTest() {
        return Response.ok().build();
    }
}
