package com.unla.Grupo14OO22021.services;

import java.util.List;

import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.UsuarioModel;

public interface IUsuarioService {
	
	public List<Usuario> getAll();
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	
	public boolean remove(int id);
}
