package br.com.quarkus.base.controller.exception.badrequest;

public class BadRequestException extends RuntimeException {

    public BadRequestException(){
        super("Bad Request!");
    }

    public BadRequestException(String msgCode){
        super(msgCode);
    }

    public BadRequestException(Exception e){
        super(e.getMessage());
    }
}
