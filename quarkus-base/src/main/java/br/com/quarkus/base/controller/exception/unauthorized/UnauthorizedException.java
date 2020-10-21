package br.com.quarkus.base.controller.exception.unauthorized;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(){
        super("Unauthorized");
    }

    public UnauthorizedException(String message){
        super(message);
    }

}
