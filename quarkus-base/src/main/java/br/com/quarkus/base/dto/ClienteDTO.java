package br.com.quarkus.base.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {

    private Long idCliente;

    private String dsNome;

    private String dsCpf;

}
