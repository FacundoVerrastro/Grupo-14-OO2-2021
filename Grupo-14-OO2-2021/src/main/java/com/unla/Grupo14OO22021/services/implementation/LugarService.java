package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.converters.LugarConverter;
import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.repositories.ILugarRepository;
import com.unla.Grupo14OO22021.services.ILugarService;

@Service("lugarService")
public class LugarService implements ILugarService{
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;
	
	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;
	
	@Override
	public List<Lugar> getAll(){
		return lugarRepository.findAll();
	}
	@Override
	public LugarModel insertOrUpdate(LugarModel lugarModel) {
		Lugar lugar = lugarRepository.save(lugarConverter.modelToEntity(lugarModel));
		return lugarConverter.entityToModel(lugar);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			lugarRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
}
