package com.unla.Grupo14OO22021.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lugarPermisoPeriodo")
public class LugarPermisoPeriodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLugarPermiso;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lugarId")
    private Lugar lugar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permisoId")
    private PermisoPeriodo permisoPeriodo;

	public LugarPermisoPeriodo() {
		super();
	}

	public LugarPermisoPeriodo(Lugar lugar, PermisoPeriodo permisoPeriodo) {
		super();
		this.lugar = lugar;
		this.permisoPeriodo = permisoPeriodo;
	}

	public int getIdLugarPermiso() {
		return idLugarPermiso;
	}

	public void setIdLugarPermiso(int idLugarPermiso) {
		this.idLugarPermiso = idLugarPermiso;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public PermisoPeriodo getPermisoPeriodo() {
		return permisoPeriodo;
	}

	public void setPermisoPeriodo(PermisoPeriodo permisoPeriodo) {
		this.permisoPeriodo = permisoPeriodo;
	}

	@Override
	public String toString() {
		return "LugarPermisoPeriodo [lugar=" + lugar + ", permisoPeriodo=" + permisoPeriodo + "]";
	}
    
    
}
