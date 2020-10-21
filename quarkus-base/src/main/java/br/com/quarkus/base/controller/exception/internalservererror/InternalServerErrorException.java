package br.com.quarkus.base.controller.exception.internalservererror;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(){
        super("Bad Request!");
    }

    public InternalServerErrorException(String msgCode){
        super(msgCode);
    }

    public InternalServerErrorException(Exception e){
        super(e.getMessage());
    }
}
