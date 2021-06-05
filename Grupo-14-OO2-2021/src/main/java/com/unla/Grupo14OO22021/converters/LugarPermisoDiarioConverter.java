package com.unla.Grupo14OO22021.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo14OO22021.entities.LugarPermisoDiario;
import com.unla.Grupo14OO22021.models.LugarPermisoDiarioModel;

@Component("lugarPermisoDiarioConverter")
public class LugarPermisoDiarioConverter {
	
	
	public LugarPermisoDiarioModel entityToModel(LugarPermisoDiario lugarPermisoDiario) {
		LugarConverter lugarConverter = new LugarConverter();
		PermisoDiarioConverter permisoDiarioConverter = new PermisoDiarioConverter();
		return new LugarPermisoDiarioModel(lugarConverter.entityToModel(lugarPermisoDiario.getLugar()),
				permisoDiarioConverter.entityToModel(lugarPermisoDiario.getPermisoDiario()));
	}
	
	public LugarPermisoDiario modelToEntity(LugarPermisoDiarioModel lugarPermisoDiarioModel) {
		LugarConverter lugarConverter = new LugarConverter();
		PermisoDiarioConverter permisoDiarioConverter = new PermisoDiarioConverter();
		
		return new LugarPermisoDiario(lugarConverter.modelToEntity(lugarPermisoDiarioModel.getLugar()),
				permisoDiarioConverter.modelToEntity(lugarPermisoDiarioModel.getPermisoDiario()));
	}
}
