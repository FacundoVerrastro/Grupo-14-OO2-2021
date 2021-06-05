package com.unla.Grupo14OO22021.models;


public class LugarPermisoPeriodoModel {
	
	private int idLugarPeriodo;
	
    private LugarModel lugar;

    private PermisoPeriodoModel permisoPeriodo;

	public LugarPermisoPeriodoModel() {
		super();
	}

	public LugarPermisoPeriodoModel(LugarModel lugar, PermisoPeriodoModel permisoPeriodo) {
		super();
		this.lugar = lugar;
		this.permisoPeriodo = permisoPeriodo;
	}

	public int getIdLugarPeriodo() {
		return idLugarPeriodo;
	}

	public void setIdLugarPeriodo(int idLugarPeriodo) {
		this.idLugarPeriodo = idLugarPeriodo;
	}

	public LugarModel getLugar() {
		return lugar;
	}

	public void setLugar(LugarModel lugar) {
		this.lugar = lugar;
	}

	public PermisoPeriodoModel getPermisoPeriodo() {
		return permisoPeriodo;
	}

	public void setPermisoPeriodo(PermisoPeriodoModel permisoPeriodo) {
		this.permisoPeriodo = permisoPeriodo;
	}
	
	
}
