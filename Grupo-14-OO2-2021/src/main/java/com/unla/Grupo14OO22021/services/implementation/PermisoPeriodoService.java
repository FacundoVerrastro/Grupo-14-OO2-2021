package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.converters.PermisoPeriodoConverter;
import com.unla.Grupo14OO22021.entities.PermisoPeriodo;
import com.unla.Grupo14OO22021.models.PermisoPeriodoModel;
import com.unla.Grupo14OO22021.repositories.IPermisoPeriodoRepository;
import com.unla.Grupo14OO22021.services.IPermisoPeriodoService;

@Service("permisoPeriodoService")
public class PermisoPeriodoService implements IPermisoPeriodoService{
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Autowired
	@Qualifier("permisoPeriodoConverter")
	private PermisoPeriodoConverter permisoPeriodoConverter;
	
	@Override
	public List<PermisoPeriodo> getAll(){
		return permisoPeriodoRepository.findAll();
	};
	
	@Override
	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permisoPeriodoModel) {
		PermisoPeriodo permisoPeriodo = permisoPeriodoRepository.save(permisoPeriodoConverter.modelToEntity(permisoPeriodoModel));
		return permisoPeriodoConverter.entityToModel(permisoPeriodo);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			permisoPeriodoRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
