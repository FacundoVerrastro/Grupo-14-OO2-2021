package com.unla.Grupo14OO22021.entities;


import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "perfil")//, uniqueConstraints=@UniqueConstraint(columnNames= {"tipo","idPerfil"})
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPerfil;
	
	@Column (name= "tipo")
	private String tipo;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
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

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", tipo=" + tipo + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt+"]";
	}
}
