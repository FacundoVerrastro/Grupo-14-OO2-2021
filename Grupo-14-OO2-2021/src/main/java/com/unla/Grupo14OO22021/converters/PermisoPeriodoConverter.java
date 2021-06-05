package com.unla.Grupo14OO22021.converters;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.PermisoPeriodo;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.models.PermisoPeriodoModel;

@Component("permisoPeriodoConverter")
public class PermisoPeriodoConverter {
	
	public PermisoPeriodoModel entityToModel(PermisoPeriodo permisoPeriodo) {
		UsuarioConverter usuarioConverter = new UsuarioConverter();
		RodadoConverter rodadoConverter = new RodadoConverter();
		
		return new PermisoPeriodoModel(permisoPeriodo.getIdPermiso(),usuarioConverter.entityToModel(permisoPeriodo.getPedido()),permisoPeriodo.getFecha(),
				permisoPeriodo.getCantDias(),permisoPeriodo.isVacaciones(),rodadoConverter.entityToModel(permisoPeriodo.getRodado()));
	}
	
	public PermisoPeriodo modelToEntity(PermisoPeriodoModel permisoPeriodoModel) {
		UsuarioConverter usuarioConverter = new UsuarioConverter();
		RodadoConverter rodadoConverter = new RodadoConverter();
		
		return new PermisoPeriodo(permisoPeriodoModel.getIdPermiso(),usuarioConverter.modelToEntity(permisoPeriodoModel.getPedido()),permisoPeriodoModel.getFecha(),
				permisoPeriodoModel.getCantDias(),permisoPeriodoModel.isVacaciones(),rodadoConverter.modelToEntity(permisoPeriodoModel.getRodado()));
	}
}
