package com.unla.Grupo14OO22021.services;

import java.util.List;

import com.unla.Grupo14OO22021.entities.PermisoPeriodo;
import com.unla.Grupo14OO22021.models.PermisoPeriodoModel;

public interface IPermisoPeriodoService {

	public List<PermisoPeriodo> getAll();
	
	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permisoPeriodoModel);
	
	public boolean remove(int id);
}
