package com.unla.Grupo14OO22021.entities;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "perfil")//, uniqueConstraints=@UniqueConstraint(columnNames= {"tipo","idPerfil"})
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="perfil")
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	@Column (name= "tipo", nullable = false)
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
