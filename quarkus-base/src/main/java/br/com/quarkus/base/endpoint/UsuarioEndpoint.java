package br.com.quarkus.base.endpoint;

import br.com.quarkus.base.controller.UsuarioController;
import br.com.quarkus.base.dto.UsuarioDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioEndpoint {

    @Inject
    UsuarioController usuarioController;

    @POST
    public Response create(UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioController.create(usuarioDTO);
        return Response.ok(usuario).build();
    }

    @PUT
    public Response update(UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioController.update(usuarioDTO);
        return Response.ok(usuario).build();
    }

}
