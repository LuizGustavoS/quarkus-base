package br.com.quarkus.base.controller.exception.unauthorized;

import br.com.quarkus.base.controller.exception.ErrorResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnauthorizedHandler implements ExceptionMapper<UnauthorizedException> {

    @Override
    public Response toResponse(UnauthorizedException exception) {
        ErrorResponse response = new ErrorResponse(Response.Status.UNAUTHORIZED, exception.getMessage());
        return Response.status(Response.Status.UNAUTHORIZED)
                .type(MediaType.APPLICATION_JSON)
                .entity(response)
                .build();
    }

    public Response getResponse(){
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ErrorResponse(Response.Status.UNAUTHORIZED, "Unauthorized"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}