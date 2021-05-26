package com.unla.Grupo14OO22021.models;

import java.util.Set;

public class PerfilModel {

	private int idPerfil;
	private String tipo;
	private Set<UsuarioModel> usuarios;

	public PerfilModel() {
		super();
	}

	public PerfilModel(int idPerfil, String tipo) {
		super();
		this.idPerfil = idPerfil;
		this.tipo = tipo;
	}
	

	public PerfilModel(int idPerfil, String tipo, Set<UsuarioModel> usuarios) {
		super();
		this.idPerfil = idPerfil;
		this.tipo = tipo;
		this.usuarios = usuarios;
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

	public Set<UsuarioModel> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}
	
}
