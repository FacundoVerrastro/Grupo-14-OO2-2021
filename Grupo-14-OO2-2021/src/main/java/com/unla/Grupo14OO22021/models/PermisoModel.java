package com.unla.Grupo14OO22021.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PermisoModel {
	protected int idPermiso;
	protected UsuarioModel pedido;
	protected LocalDate fecha;
	
	
	public PermisoModel() {
		super();
	}

	public PermisoModel(int idPermiso, UsuarioModel pedido, LocalDate fecha) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
	}
	
	public int getIdPermiso() {
		return idPermiso;
	}
	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}
	public UsuarioModel getPedido() {
		return pedido;
	}
	public void setPedido(UsuarioModel pedido) {
		this.pedido = pedido;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
