package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.converters.PermisoDiarioConverter;
import com.unla.Grupo14OO22021.entities.PermisoDiario;
import com.unla.Grupo14OO22021.models.PermisoDiarioModel;
import com.unla.Grupo14OO22021.repositories.IPermisoDiarioRepository;
import com.unla.Grupo14OO22021.services.IPermisoDiarioService;

@Service("permisoDiarioService")
public class PermisoDiarioService implements IPermisoDiarioService{
	
	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;
	
	@Autowired
	@Qualifier("permisoDiarioConverter")
	private PermisoDiarioConverter permisoDiarioConverter;
	
	@Override
	public List<PermisoDiario> getAll(){
		return permisoDiarioRepository.findAll();
	};
	
	@Override
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permisoDiarioModel) {
		PermisoDiario permisoDiario = permisoDiarioRepository.save(permisoDiarioConverter.modelToEntity(permisoDiarioModel));
		return permisoDiarioConverter.entityToModel(permisoDiario);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			permisoDiarioRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
