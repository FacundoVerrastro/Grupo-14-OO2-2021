package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.unla.Grupo14OO22021.converters.LugarPermisoPeriodoConverter;
import com.unla.Grupo14OO22021.entities.LugarPermisoDiario;
import com.unla.Grupo14OO22021.entities.LugarPermisoPeriodo;
import com.unla.Grupo14OO22021.models.LugarPermisoDiarioModel;
import com.unla.Grupo14OO22021.models.LugarPermisoPeriodoModel;
import com.unla.Grupo14OO22021.repositories.ILugarPermisoDiarioRepository;
import com.unla.Grupo14OO22021.repositories.ILugarPermisoPeriodoRepository;
import com.unla.Grupo14OO22021.services.ILugarPermisoDiarioService;
import com.unla.Grupo14OO22021.services.ILugarPermisoPeriodoService;

public class LugarPermisoPeriodoService implements ILugarPermisoPeriodoService{
	@Autowired
	@Qualifier("lugarPermisoPeriodoRepository")
	private ILugarPermisoPeriodoRepository lugarPermisoPeriodoRepository;
	
	@Autowired
	@Qualifier("lugarPermisoPeriodoConverter")
	private LugarPermisoPeriodoConverter lugarPermisoPeriodoConverter;
	
	@Override
	public List<LugarPermisoPeriodo> getAll(){
		return lugarPermisoPeriodoRepository.findAll();
	};
	@Override
	public LugarPermisoPeriodoModel insertOrUpdate(LugarPermisoPeriodoModel lugarPermisoPeriodoModel) {
		LugarPermisoPeriodo lugarPermisoPeriodo = lugarPermisoPeriodoRepository.save(lugarPermisoPeriodoConverter.modelToEntity(lugarPermisoPeriodoModel));
		return lugarPermisoPeriodoConverter.entityToModel(lugarPermisoPeriodo);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			lugarPermisoPeriodoRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
