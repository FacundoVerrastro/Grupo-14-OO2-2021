package com.unla.Grupo14OO22021.models;


public class LugarPermisoDiarioModel {
	
	private int idLugarPermiso;
	
    private LugarModel lugar;

    private PermisoDiarioModel permisoDiario;

	public LugarPermisoDiarioModel() {
		super();
	}

	public LugarPermisoDiarioModel(LugarModel lugar, PermisoDiarioModel permisoDiario) {
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

	public LugarModel getLugar() {
		return lugar;
	}

	public void setLugar(LugarModel lugar) {
		this.lugar = lugar;
	}

	public PermisoDiarioModel getPermisoDiario() {
		return permisoDiario;
	}

	public void setPermisoDiario(PermisoDiarioModel permisoDiario) {
		this.permisoDiario = permisoDiario;
	}
	
}
