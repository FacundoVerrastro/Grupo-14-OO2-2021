package com.unla.Grupo14OO22021.models;

import java.time.LocalDate;
import java.util.Set;


public class PermisoDiarioModel extends PermisoModel {
	private String motivo;
	
	
	public PermisoDiarioModel() {
		super();
	}



	public PermisoDiarioModel(int idPermiso, UsuarioModel pedido, LocalDate fecha, 
			String motivo) {
		super(idPermiso, pedido, fecha);
		this.motivo = motivo;
	}

	

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiarioModel [fecha=" + fecha + ", idPermiso=" + idPermiso
				+ ", pedido=" + pedido + ", motivo=" + motivo + "]";
	}
	
	
}
