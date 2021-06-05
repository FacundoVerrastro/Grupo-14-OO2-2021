package com.unla.Grupo14OO22021.services;

import java.util.List;

import com.unla.Grupo14OO22021.entities.Rodado;
import com.unla.Grupo14OO22021.models.RodadoModel;


public interface IRodadoService {
	
	public List<Rodado> getAll();
	
	public RodadoModel insertOrUpdate(RodadoModel rodadoModel);
	
	public boolean remove(int id);
}
