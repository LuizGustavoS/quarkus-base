package br.com.quarkus.base.converter;

import br.com.quarkus.base.orm.Cliente;
import br.com.quarkus.base.dto.ClienteDTO;

public class ClienteConverter extends GenericConverter<Cliente, ClienteDTO> {

    @Override
    public ClienteDTO ormToDto(Cliente cliente) {

        if (cliente == null){
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();
        copy(cliente, clienteDTO);
        return clienteDTO;
    }

    @Override
    public Cliente dtoToOrm(ClienteDTO clienteDTO) {

        if (clienteDTO == null){
            return null;
        }

        Cliente cliente = new Cliente();
        copy(clienteDTO, cliente);
        return cliente;
    }

    @Override
    protected String[] ignoreProperties() {
        return new String[0];
    }
}
