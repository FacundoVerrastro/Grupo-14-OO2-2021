package com.unla.Grupo14OO22021.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.unla.Grupo14OO22021.entities.Lugar;


public class PermisoDiarioModel extends PermisoModel {
	private String motivo;
	private List<Lugar> lugares = new ArrayList<Lugar>(); 
	
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
	

	public List<Lugar> getLugares() {
		return lugares;
	}



	public void setLugares(List<Lugar> lugares) {
		this.lugares = lugares;
	}



	@Override
	public String toString() {
		return "PermisoDiarioModel [fecha=" + fecha + ", idPermiso=" + idPermiso
				+ ", pedido=" + pedido + ", motivo=" + motivo + "]";
	}
	
	
}
