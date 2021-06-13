package com.unla.Grupo14OO22021.models;


public class PerfilModel {

	private int idPerfil;
	private String tipo;

	public PerfilModel() {
		super();
	}

	public PerfilModel(int idPerfil, String tipo) {
		super();
		this.idPerfil = idPerfil;
		this.tipo = tipo;
	}
	


	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}