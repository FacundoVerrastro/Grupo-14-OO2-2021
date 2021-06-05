package com.unla.Grupo14OO22021.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PermisoDiario")
public class PermisoDiario extends Permiso{
	

	@Column(name = "motivo")
	private String motivo;
	
	
	
	public PermisoDiario() {
		super();
	}
	
	
	public PermisoDiario(Usuario pedido, LocalDate fecha, String motivo) {
		super(pedido, fecha);
		this.motivo = motivo;
	}


	public PermisoDiario(int idPermiso, Usuario pedido, LocalDate fecha, String motivo) {
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
		return "PermisoDiario [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha + ", motivo="
				+ motivo + "]";
	}
	
	
}
