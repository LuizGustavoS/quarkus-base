package br.com.quarkus.base.converter;

import br.com.quarkus.base.dto.UsuarioDTO;
import br.com.quarkus.base.orm.Usuario;

public class UsuarioConverter extends GenericConverter<Usuario, UsuarioDTO>{

    @Override
    public UsuarioDTO ormToDto(Usuario usuario) {

        if (usuario == null){
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        copy(usuario, usuarioDTO);
        return usuarioDTO;
    }

    @Override
    public Usuario dtoToOrm(UsuarioDTO usuarioDTO) {

        if (usuarioDTO == null){
            return null;
        }

        Usuario usuario = new Usuario();
        copy(usuarioDTO, usuario);
        return usuario;
    }

    @Override
    protected String[] ignoreProperties() {
        return new String[0];
    }
}
