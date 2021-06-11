package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.converters.RodadoConverter;
import com.unla.Grupo14OO22021.entities.Rodado;
import com.unla.Grupo14OO22021.models.RodadoModel;
import com.unla.Grupo14OO22021.repositories.IRodadoRepository;
import com.unla.Grupo14OO22021.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService{
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;
	
	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;
	
	@Override
	public List<Rodado> getAll(){
		return rodadoRepository.findAll();
	};
	
	@Override
	public RodadoModel insertOrUpdate(RodadoModel rodadoModel) {
		Rodado rodado = rodadoRepository.save(rodadoConverter.modelToEntity(rodadoModel));
		return rodadoConverter.entityToModel(rodado);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			rodadoRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
