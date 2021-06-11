package com.unla.Grupo14OO22021.converters;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.PermisoDiario;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.models.PermisoDiarioModel;

@Component("permisoDiarioConverter")
public class PermisoDiarioConverter {
	
	
	public PermisoDiarioModel entityToModel(PermisoDiario permisoDiario) {
		UsuarioConverter usuarioConverter = new UsuarioConverter();
		LugarConverter lugarConverter = new LugarConverter();
		Set<LugarModel> setLugar = new HashSet<LugarModel>();
		
		for (Iterator<Lugar> it = permisoDiario.getDesdeHasta().iterator(); it.hasNext(); ) {
	        Lugar l = it.next();
	        setLugar.add(lugarConverter.entityToModel(l));
	    }
		
		return new PermisoDiarioModel(permisoDiario.getIdPermiso(),usuarioConverter.entityToModel(permisoDiario.getPedido()),permisoDiario.getFecha(),
				setLugar,permisoDiario.getMotivo());
	}
	
	public PermisoDiario modelToEntity(PermisoDiarioModel permisoDiarioModel) {
		UsuarioConverter usuarioConverter = new UsuarioConverter();
		LugarConverter lugarConverter = new LugarConverter();
		Set<Lugar> setLugar = new HashSet<Lugar>();
		
		for (Iterator<LugarModel> it = permisoDiarioModel.getDesdeHasta().iterator(); it.hasNext(); ) {
	        LugarModel l = it.next();
	        setLugar.add(lugarConverter.modelToEntity(l));
	    }
		
		return new PermisoDiario(permisoDiarioModel.getIdPermiso(),usuarioConverter.modelToEntity(permisoDiarioModel.getPedido()),permisoDiarioModel.getFecha(),
				setLugar,permisoDiarioModel.getMotivo());
	}
}
