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
		LugarConverter lugarConverter = new LugarConverter();
		Set<LugarModel> setLugar = new HashSet<LugarModel>();
		
		for (Iterator<Lugar> it = permisoPeriodo.getDesdeHasta().iterator(); it.hasNext(); ) {
	        Lugar l = it.next();
	        setLugar.add(lugarConverter.entityToModel(l));
	    }
		return new PermisoPeriodoModel(permisoPeriodo.getIdPermiso(),usuarioConverter.entityToModel(permisoPeriodo.getPedido()),permisoPeriodo.getFecha(),
				setLugar,permisoPeriodo.getCantDias(),permisoPeriodo.isVacaciones(),rodadoConverter.entityToModel(permisoPeriodo.getRodado()));
	}
	
	public PermisoPeriodo modelToEntity(PermisoPeriodoModel permisoPeriodoModel) {
		UsuarioConverter usuarioConverter = new UsuarioConverter();
		RodadoConverter rodadoConverter = new RodadoConverter();
		LugarConverter lugarConverter = new LugarConverter();
		Set<Lugar> setLugar = new HashSet<Lugar>();
		
		for (Iterator<LugarModel> it = permisoPeriodoModel.getDesdeHasta().iterator(); it.hasNext(); ) {
	        LugarModel l = it.next();
	        setLugar.add(lugarConverter.modelToEntity(l));
	    }
		return new PermisoPeriodo(permisoPeriodoModel.getIdPermiso(),usuarioConverter.modelToEntity(permisoPeriodoModel.getPedido()),permisoPeriodoModel.getFecha(),
				setLugar,permisoPeriodoModel.getCantDias(),permisoPeriodoModel.isVacaciones(),rodadoConverter.modelToEntity(permisoPeriodoModel.getRodado()));
	}
}
