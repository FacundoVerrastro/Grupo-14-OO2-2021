package com.unla.Grupo14OO22021.services;

import java.util.List;

import com.unla.Grupo14OO22021.entities.LugarPermisoPeriodo;
import com.unla.Grupo14OO22021.models.LugarPermisoPeriodoModel;

public interface ILugarPermisoPeriodoService {
	
	public List<LugarPermisoPeriodo> getAll();
	
	public LugarPermisoPeriodoModel insertOrUpdate(LugarPermisoPeriodoModel lugarPermisoDiarioModel);
	
	public boolean remove(int id);
}
