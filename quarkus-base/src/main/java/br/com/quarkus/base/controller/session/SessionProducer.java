package br.com.quarkus.base.controller.session;


import br.com.quarkus.base.controller.exception.unauthorized.UnauthorizedException;
import br.com.quarkus.base.orm.AccessToken;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

public class SessionProducer {

    @Inject
    SessionCache sessionCache;

    @Default
    @UserSession
    @RequestScoped
    public AccessToken loadSession(){

        String authorization = SessionHolder.getCurrentAuthorization();
        if (authorization == null){
            throw new UnauthorizedException();
        }

        authorization = authorization.substring(7);
        AccessToken accessToken = sessionCache.get(authorization);
        if (accessToken == null){
            accessToken = AccessToken.findById(authorization);
            sessionCache.update(authorization, accessToken);
        }

        return accessToken;
    }

}
