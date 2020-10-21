package br.com.quarkus.base.controller.session;

import br.com.quarkus.base.orm.AccessToken;

import javax.inject.Singleton;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class SessionCache {

    public AccessToken get(String token){
        return usuarios.get(token);
    }

    public void update(String token, AccessToken accessToken){
        usuarios.put(token, accessToken);
    }

    private final ConcurrentHashMap<String, AccessToken> usuarios = new ConcurrentHashMap<>();

}
