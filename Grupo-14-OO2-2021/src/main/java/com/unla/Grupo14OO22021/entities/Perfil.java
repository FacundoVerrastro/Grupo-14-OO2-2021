package com.unla.Grupo14OO22021.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;

	@Column (name= "tipo", nullable = false)
	private String tipo;

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

	


	

	
	
}
