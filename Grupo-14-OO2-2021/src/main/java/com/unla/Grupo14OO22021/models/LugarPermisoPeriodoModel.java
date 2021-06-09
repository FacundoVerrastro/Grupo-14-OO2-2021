package com.unla.Grupo14OO22021.models;


public class LugarPermisoPeriodoModel {
	
	private PermisoPeriodoModel permisoPeriodo;
	
    private int idLugarDesde;

    private int idLugarHasta;

	public LugarPermisoPeriodoModel() {
		super();
	}

	public LugarPermisoPeriodoModel(PermisoPeriodoModel permisoPeriodo, int idLugarDesde, int idLugarHasta) {
		super();
		this.permisoPeriodo = permisoPeriodo;
		this.idLugarDesde = idLugarDesde;
		this.idLugarHasta = idLugarHasta;
	}

	public PermisoPeriodoModel getPermisoPeriodo() {
		return permisoPeriodo;
	}

	public void setPermisoPeriodo(PermisoPeriodoModel permisoPeriodo) {
		this.permisoPeriodo = permisoPeriodo;
	}

	public int getIdLugarDesde() {
		return idLugarDesde;
	}

	public void setIdLugarDesde(int idLugarDesde) {
		this.idLugarDesde = idLugarDesde;
	}

	public int getIdLugarHasta() {
		return idLugarHasta;
	}

	public void setIdLugarHasta(int idLugarHasta) {
		this.idLugarHasta = idLugarHasta;
	}

	
}
