package com.unla.Grupo14OO22021.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.models.LugarModel;

public interface ILugarService {
	
	public List<Lugar> getAll();
	
	public LugarModel insertOrUpdate(LugarModel lugarModel);
	
	public boolean remove(int id);
}
