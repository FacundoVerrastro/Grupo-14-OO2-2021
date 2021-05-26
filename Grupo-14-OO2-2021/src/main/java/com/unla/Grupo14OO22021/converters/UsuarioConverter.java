package com.unla.Grupo14OO22021.converters;



import org.springframework.stereotype.Component;


import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getIdUsuario(),usuario.getNombre(),
				usuario.getApellido(),usuario.getTipoDocumento(),usuario.getNumeroDocumento(),
				usuario.getEmail(),usuario.getNomUsuario(),usuario.getContraseña());
	}
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		PerfilConverter perfilConverter = new PerfilConverter();
		return new Usuario(usuarioModel.getIdUsuario(), usuarioModel.getNombre(), 
				usuarioModel.getApellido(), usuarioModel.getTipoDocumento(), 
				usuarioModel.getNumeroDocumento(), usuarioModel.getEmail(), 
				usuarioModel.getNomUsuario(), usuarioModel.getContraseña(), perfilConverter.modelToEntity(usuarioModel.getPerfil()));
	}
}
