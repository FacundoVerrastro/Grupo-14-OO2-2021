package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.converters.LugarConverter;
import com.unla.Grupo14OO22021.converters.LugarPermisoDiarioConverter;
import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.LugarPermisoDiario;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.models.LugarPermisoDiarioModel;
import com.unla.Grupo14OO22021.repositories.ILugarPermisoDiarioRepository;
import com.unla.Grupo14OO22021.repositories.ILugarRepository;
import com.unla.Grupo14OO22021.services.ILugarPermisoDiarioService;

@Service("lugarPermisoDiarioService")
public class LugarPermisoDiarioService implements ILugarPermisoDiarioService{
	
	@Autowired
	@Qualifier("lugarPermisoDiarioRepository")
	private ILugarPermisoDiarioRepository lugarPermisoDiarioRepository;
	
	@Autowired
	@Qualifier("lugarPermisoDiarioConverter")
	private LugarPermisoDiarioConverter lugarPermisoDiarioConverter;
	
	@Override
	public List<LugarPermisoDiario> getAll(){
		return lugarPermisoDiarioRepository.findAll();
	};
	@Override
	public LugarPermisoDiarioModel insertOrUpdate(LugarPermisoDiarioModel lugarPermisoDiarioModel) {
		LugarPermisoDiario lugarPermisoDiario = lugarPermisoDiarioRepository.save(lugarPermisoDiarioConverter.modelToEntity(lugarPermisoDiarioModel));
		return lugarPermisoDiarioConverter.entityToModel(lugarPermisoDiario);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			lugarPermisoDiarioRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
