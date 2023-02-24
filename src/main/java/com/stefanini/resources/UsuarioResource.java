package com.stefanini.resources;

import javax.inject.Inject;
import javax.validation.Valid;
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
import javax.ws.rs.core.Response.Status;

import com.stefanini.model.Usuario;
import com.stefanini.service.UsuarioService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/usuario")
public class UsuarioResource {

    @Inject
    private UsuarioService usuarioService;

    @GET
    public Response listAll() {
        return Response.ok().entity(usuarioService.getAll()).build();
    }

    @POST
    public Response save(@Valid Usuario usuario) {
        return Response.status(Status.CREATED).entity(usuarioService.save(usuario)).build();
    }

    @PUT
    public Response update(@Valid Usuario usuario) {
        return Response.status(Status.CREATED).entity(usuarioService.update(usuario)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam(value = "id") Long id) {
        return Response.ok().entity(usuarioService.getById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam(value = "id") Long id) {
        usuarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/aniversariantes/{mes}")
    public Response listUsersFromBirthdayMonth(@PathParam(value = "mes") int mes) {
        return Response.ok().entity(usuarioService.getAllUsersFromBirthdayMonth(mes)).build();
    }

}
