package com.unla.Grupo14OO22021.models;

import java.util.Set;

public class Perfil {

	private int idPerfil;
	private String tipo;
	private Set<Usuario> usuarios;

	public Perfil() {
		super();
	}

	public Perfil(int idPerfil, String tipo) {
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

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
