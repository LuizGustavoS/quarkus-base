package br.com.quarkus.base.controller;

import br.com.quarkus.base.converter.UsuarioConverter;
import br.com.quarkus.base.dto.UsuarioDTO;
import br.com.quarkus.base.orm.Usuario;

import javax.inject.Inject;

public class UsuarioController extends GenericController {

    @Inject
    UsuarioConverter usuarioConverter;

    public UsuarioDTO create(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.dtoToOrm(usuarioDTO);
        usuario.persist();
        return usuarioConverter.ormToDto(usuario);
    }

    public UsuarioDTO update(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.dtoToOrm(usuarioDTO);
        usuario.persist();
        return usuarioConverter.ormToDto(usuario);
    }

}
