package com.unla.Grupo14OO22021.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.converters.LugarConverter;
import com.unla.Grupo14OO22021.converters.PermisoDiarioConverter;
import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.PermisoDiario;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.models.PermisoDiarioModel;
import com.unla.Grupo14OO22021.repositories.ILugarRepository;
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
	
	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;
	
	@Override
	public List<PermisoDiario> getAll(){
		return permisoDiarioRepository.findAll();
	};
	
	@Override
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permisoDiarioModel) {
		PermisoDiarioModel newPermisoDiarioModel = new PermisoDiarioModel();
		newPermisoDiarioModel.setIdPermiso(permisoDiarioModel.getIdPermiso());
		newPermisoDiarioModel.setFecha(permisoDiarioModel.getFecha());
		newPermisoDiarioModel.setMotivo(permisoDiarioModel.getMotivo());
		newPermisoDiarioModel.setPedido(permisoDiarioModel.getPedido());
		newPermisoDiarioModel.getDesdeHasta().
			addAll(permisoDiarioModel.getDesdeHasta()
					.stream()
					.map( l ->{
						Lugar ll = lugarRepository.findByIdLugar(l.getIdLugar());
						ll.getPermisosDiario().add(permisoDiarioConverter.modelToEntity(newPermisoDiarioModel));
						return lugarConverter.entityToModel(ll);
					}).collect(Collectors.toList()));
			
		PermisoDiario permisoDiario = permisoDiarioRepository.save(permisoDiarioConverter.modelToEntity(newPermisoDiarioModel));
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
