package com.unla.Grupo14OO22021.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.unla.Grupo14OO22021.entities.Lugar;


public class PermisoDiarioModel extends PermisoModel {
	public Set<LugarModel> desdeHasta; 
	private String motivo;
	
	public PermisoDiarioModel() {
		super();
	}

	public PermisoDiarioModel(int idPermiso, UsuarioModel pedido, LocalDate fecha, 
			String motivo) {
		super(idPermiso, pedido, fecha);
		this.motivo = motivo;
	}

	public PermisoDiarioModel(int idPermiso, UsuarioModel pedido, LocalDate fecha,
			Set<LugarModel> desdeHasta,String motivo) {
		super(idPermiso, pedido, fecha);
		this.motivo = motivo;
		this.desdeHasta = desdeHasta;
	}

	public Set<LugarModel> getDesdeHasta() {
		return desdeHasta;
	}



	public void setDesdeHasta(Set<LugarModel> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}



	public String getMotivo() {
		return motivo;
	}



	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}



	@Override
	public String toString() {
		return "PermisoDiarioModel [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha + ", motivo="
				+ motivo + ", desdeHasta=" + desdeHasta + "]";
	}
	
	
}
