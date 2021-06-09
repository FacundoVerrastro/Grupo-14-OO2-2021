package com.unla.Grupo14OO22021.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "lugar")
public class Lugar {
	
	@Id
	private int idLugar;
	
	@Column (name= "lugar", nullable = false)
	private String lugar;
	
	@Column (name= "codigoPostal", nullable = false)
	private String codigoPostal;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToMany(mappedBy = "desdeHasta", cascade = CascadeType.MERGE)
    Set<PermisoDiario> permisosDiario;
	
	@ManyToMany(mappedBy = "desdeHasta", cascade = CascadeType.MERGE)
    Set<PermisoPeriodo> permisosPeriodo;
	
	public Lugar() {
		super();
	}
	
	public Lugar(int idLugar, String lugar, String codigoPostal) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}

	public Lugar(String lugar, String codigoPostal, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	
	public Set<PermisoDiario> getPermisosDiario() {
		return permisosDiario;
	}

	public void setPermisosDiario(Set<PermisoDiario> permisosDiario) {
		this.permisosDiario = permisosDiario;
	}

	public Set<PermisoPeriodo> getPermisosPeriodo() {
		return permisosPeriodo;
	}

	public void setPermisosPeriodo(Set<PermisoPeriodo> permisosPeriodo) {
		this.permisosPeriodo = permisosPeriodo;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
