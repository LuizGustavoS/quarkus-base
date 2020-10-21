package br.com.quarkus.base.endpoint;

import br.com.quarkus.base.dto.ClienteDTO;
import br.com.quarkus.base.orm.Cliente;
import br.com.quarkus.base.controller.ClienteController;
import br.com.quarkus.base.dto.paginacao.PaginacaoDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteEndpoint {

    @Inject
    ClienteController clienteController;

    @POST
    public Response create(ClienteDTO clienteDTO){
        ClienteDTO cliente = clienteController.create(clienteDTO);
        return Response.ok(cliente).build();
    }

    @PUT
    public Response update(ClienteDTO clienteDTO){
        ClienteDTO cliente = clienteController.update(clienteDTO);
        return Response.ok(cliente).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        clienteController.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id){
        Cliente cliente = clienteController.findById(id);
        return Response.ok(cliente).build();
    }

    @POST
    @Path("search")
    public Response search(PaginacaoDTO paginacaoDTO){
        PaginacaoDTO search = clienteController.search(paginacaoDTO);
        return Response.ok(search).build();
    }

}
