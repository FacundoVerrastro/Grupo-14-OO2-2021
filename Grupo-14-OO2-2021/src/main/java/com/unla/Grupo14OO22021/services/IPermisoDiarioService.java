package com.unla.Grupo14OO22021.services;

import java.util.List;

import com.unla.Grupo14OO22021.entities.PermisoDiario;
import com.unla.Grupo14OO22021.models.PermisoDiarioModel;

public interface IPermisoDiarioService {
	public List<PermisoDiario> getAll();
	
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permisoDiarioModel);
	
	public boolean remove(int id);
}
