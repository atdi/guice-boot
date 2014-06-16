package org.aav.guice.resources;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import org.aav.guice.model.User;
import org.aav.guice.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 14/06/2014.
 */
@Path("/users")
@RequestScoped
@Produces("application/json")
public class UserResource {

    @Inject
    private UserService userService;


    @POST
    @Consumes("application/json")
    public Response addUser(User user) {
        return Response.ok().entity(userService.addUser(user)).build();
    }

    @GET
    @Path("/{userId}")
    public Response getUser(@PathParam("userId") String userId) {
        return Response.ok().entity(userService.findById(UUID.fromString(userId))).build();
    }
}
