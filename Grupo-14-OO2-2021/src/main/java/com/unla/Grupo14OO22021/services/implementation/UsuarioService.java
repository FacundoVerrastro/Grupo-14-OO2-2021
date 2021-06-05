package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.converters.UsuarioConverter;
import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.UsuarioModel;
import com.unla.Grupo14OO22021.repositories.IUsuarioRepository;
import com.unla.Grupo14OO22021.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Override
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	};
	
	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel) {
		Usuario usuario = usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModel));
		return usuarioConverter.entityToModel(usuario);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			usuarioRepository.delete(usuarioRepository.findByIdUsuario(id));
			//usuarioRepository.deleteById;
			return true;
		}catch(Exception e){
			return false;
		}
	}
}