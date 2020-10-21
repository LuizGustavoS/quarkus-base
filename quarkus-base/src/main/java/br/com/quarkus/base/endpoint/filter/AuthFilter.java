package br.com.quarkus.base.endpoint.filter;

import br.com.quarkus.base.controller.exception.unauthorized.UnauthorizedHandler;
import br.com.quarkus.base.orm.AccessToken;
import br.com.quarkus.base.endpoint.AuthEndpoint;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.util.Optional;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo info;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        if (info.getResourceClass().equals(AuthEndpoint.class)){
            return;
        }

        String header = requestContext.getHeaderString("Authorization");
        if (header == null || header.trim().isEmpty() || !header.toLowerCase().startsWith("bearer")){
            requestContext.abortWith(new UnauthorizedHandler().getResponse());
            return;
        }

        Optional<AccessToken> accessToken = AccessToken.testToken(header.substring(7));
        if (accessToken.isEmpty()){
            requestContext.abortWith(new UnauthorizedHandler().getResponse());
            return;
        }

        if (info.getResourceMethod().isAnnotationPresent(Authorization.class)){
            requestContext.abortWith(new UnauthorizedHandler().getResponse());
        }
    }
}