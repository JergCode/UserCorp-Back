package com.usercorp.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.usercorp.bean.UsersServiceBean;
import com.usercorp.models.User;

@Path("/user/service")
public class Service {

    @Inject
    UsersServiceBean usersBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        return Response.ok(usersBean.getAllUsers()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        return Response.ok(usersBean.getUser(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) {
        usersBean.addUser(user);
        Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        usersBean.deleteUser(id);
        Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user) {
        usersBean.editUser(user);
        Response.ok().build();
    }
}