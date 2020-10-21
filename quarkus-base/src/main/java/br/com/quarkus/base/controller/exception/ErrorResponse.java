package br.com.quarkus.base.controller.exception;

import lombok.Getter;

import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final int code;

    private final String status;

    private final String message;

    private final LocalDateTime timestamp = LocalDateTime.now();

    public ErrorResponse(Response.Status status, String message) {
        this.code = status.getStatusCode();
        this.status = status.getReasonPhrase();
        this.message = message;
    }
}
