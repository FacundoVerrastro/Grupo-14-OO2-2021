package com.unla.Grupo14OO22021.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.models.LugarModel;

@Component("lugarConverter")
public class LugarConverter {

	public LugarModel entityToModel(Lugar lugar) {
		return new LugarModel(lugar.getIdLugar(),lugar.getLugar(),lugar.getCodigoPostal());
	}
	
	public Lugar modelToEntity(LugarModel lugarModel) {
		return new Lugar(lugarModel.getIdLugar(),lugarModel.getLugar(),lugarModel.getCodPostal());
	}
}
