package com.unla.Grupo14OO22021.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo14OO22021.entities.LugarPermisoPeriodo;
import com.unla.Grupo14OO22021.models.LugarPermisoPeriodoModel;

@Component("lugarPermisoPeriodoConverter")
public class LugarPermisoPeriodoConverter {
	
	public LugarPermisoPeriodoModel entityToModel(LugarPermisoPeriodo lugarPermisoPeriodo) {
		LugarConverter lugarConverter = new LugarConverter();
		PermisoPeriodoConverter permisoPeriodoConverter = new PermisoPeriodoConverter();
		
		return new LugarPermisoPeriodoModel(lugarConverter.entityToModel(lugarPermisoPeriodo.getLugar()),
				permisoPeriodoConverter.entityToModel(lugarPermisoPeriodo.getPermisoPeriodo()));
	}
	
	public LugarPermisoPeriodo modelToEntity(LugarPermisoPeriodoModel lugarPermisoPeriodoModel) {
		LugarConverter lugarConverter = new LugarConverter();
		PermisoPeriodoConverter permisoPeriodoConverter = new PermisoPeriodoConverter();
		
		return new LugarPermisoPeriodo(lugarConverter.modelToEntity(lugarPermisoPeriodoModel.getLugar()),
				permisoPeriodoConverter.modelToEntity(lugarPermisoPeriodoModel.getPermisoPeriodo()));
	}
}
