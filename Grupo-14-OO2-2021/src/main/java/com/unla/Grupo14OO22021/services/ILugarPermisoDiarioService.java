package com.unla.Grupo14OO22021.services;

import java.util.List;

import com.unla.Grupo14OO22021.entities.LugarPermisoDiario;
import com.unla.Grupo14OO22021.models.LugarPermisoDiarioModel;

public interface ILugarPermisoDiarioService {
	
	public List<LugarPermisoDiario> getAll();
	
	public LugarPermisoDiarioModel insertOrUpdate(LugarPermisoDiarioModel lugarPermisoDiarioModel);
	
	public boolean remove(int id);
}
