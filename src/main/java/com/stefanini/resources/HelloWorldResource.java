package com.stefanini.resources;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.model.Usuario;
import com.stefanini.repository.UsuarioRepository;

@Path("/hello-world")
public class HelloWorldResource {

    @Inject
    UsuarioRepository usuarioRepository;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarUsuario(@Valid Usuario usuario) {
        Usuario usuario2 = usuarioRepository.save(usuario);

        return Response.ok(usuario2).status(Response.Status.CREATED).build();
    }

}
