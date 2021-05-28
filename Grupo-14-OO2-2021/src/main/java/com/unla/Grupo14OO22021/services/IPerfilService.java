package com.unla.Grupo14OO22021.services;

import java.util.List;

import com.unla.Grupo14OO22021.entities.Perfil;
import com.unla.Grupo14OO22021.models.PerfilModel;

public interface IPerfilService {
	
	public List<Perfil> getAll();
	
	public PerfilModel insertOrUpdate(PerfilModel perfilModel);
	
	public boolean remove(int id);
}
