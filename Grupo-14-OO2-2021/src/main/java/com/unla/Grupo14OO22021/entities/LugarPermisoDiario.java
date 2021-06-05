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
@Table(name = "lugarPermisoDiario")
public class LugarPermisoDiario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLugarPermiso;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lugarId")
    private Lugar lugar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permisoId")
    private PermisoDiario permisoDiario;

	public LugarPermisoDiario() {
		super();
	}

	public LugarPermisoDiario(Lugar lugar, PermisoDiario permisoDiario) {
		super();
		this.lugar = lugar;
		this.permisoDiario = permisoDiario;
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

	public PermisoDiario getPermisoDiario() {
		return permisoDiario;
	}

	public void setPermisoDiario(PermisoDiario permisoDiario) {
		this.permisoDiario = permisoDiario;
	}

	@Override
	public String toString() {
		return "LugarPermisoDiario [ lugar=" + lugar + ", permisoDiario="
				+ permisoDiario + "]";
	}
    
    
}
