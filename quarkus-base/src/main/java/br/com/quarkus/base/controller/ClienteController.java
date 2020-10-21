package br.com.quarkus.base.controller;

import br.com.quarkus.base.controller.session.UserSession;
import br.com.quarkus.base.converter.ClienteConverter;
import br.com.quarkus.base.dto.ClienteDTO;
import br.com.quarkus.base.dto.paginacao.ClienteSearchDTO;
import br.com.quarkus.base.dto.paginacao.PaginacaoDTO;
import br.com.quarkus.base.orm.AccessToken;
import br.com.quarkus.base.orm.Cliente;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class ClienteController extends GenericController {

    @UserSession
    AccessToken userSession;

    @Inject
    ClienteConverter clienteConverter;

    public ClienteDTO create(ClienteDTO clienteDTO){
        Cliente cliente = clienteConverter.dtoToOrm(clienteDTO);
        cliente.setUsuarioCadastro(userSession.getUsuario());
        cliente.persist();
        return clienteConverter.ormToDto(cliente);
    }

    public ClienteDTO update(ClienteDTO clienteDTO){
        Cliente cliente = clienteConverter.dtoToOrm(clienteDTO);
        cliente.persist();
        return clienteConverter.ormToDto(cliente);
    }

    public void delete(Long id){
        Cliente.findById(id).delete();
    }

    public Cliente findById(Long id){
        Optional<Cliente> cliente = Cliente.findByIdOptional(id);
        if (cliente.isEmpty()){
            throw new NotFoundException("Cliente não encontrado!");
        }
        return cliente.get();
    }

    public PaginacaoDTO search(PaginacaoDTO paginacaoDTO){

        String where = "";
        ClienteSearchDTO search = (ClienteSearchDTO) paginacaoDTO.getFilters();
        if (search.getIdCliente() != null){
            where = where.concat("c.idCliente = ? AND").replace("?", search.getIdCliente().toString());
        }if (search.getDsNome() != null && !search.getDsNome().isBlank()){
            where = where.concat("c.dsNome = '?' AND").replace("?", search.getDsNome());
        }

        where = where.isBlank()? "" : "WHERE " + where.substring(0, where.length() -3);

        String sqlCount = "SELECT COUNT(c) FROM Cliente c " + where.substring(0, where.length() -3);
        String sqlQuery = "SELECT * FROM Cliente c " + where.substring(0, where.length() -3);
        return loadSearch(paginacaoDTO, sqlCount, sqlQuery);
    }

}
