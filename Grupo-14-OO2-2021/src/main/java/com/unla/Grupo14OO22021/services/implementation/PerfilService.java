package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.entities.Perfil;
import com.unla.Grupo14OO22021.models.PerfilModel;
import com.unla.Grupo14OO22021.repositories.IPerfilRepository;
import com.unla.Grupo14OO22021.services.IPerfilService;

@Service("perfilService")
public class PerfilService implements IPerfilService{
	
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	
	@Override
	public List<Perfil> getAll(){
		return perfilRepository.findAll();
	};
	
	@Override
	public PerfilModel insertOrUpdate(PerfilModel perfilModel) {
		Perfil perfil = perfilRepository.save(perfilConverter.modelToEntity(perfilModel));
		return perfilConverter.entityToModel(perfil);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			perfilRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
