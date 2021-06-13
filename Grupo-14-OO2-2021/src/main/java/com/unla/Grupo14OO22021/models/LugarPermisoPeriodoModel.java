package com.unla.Grupo14OO22021.models;

import java.util.Set;

public class LugarPermisoPeriodoModel {
	
	private PermisoPeriodoModel permisoPeriodo;
	
	private int idPermisoPeriodo;
	
	private int idPedido;
	
    private int idLugarDesde;

    private int idLugarHasta;
    
    private Set<LugarModel> lstLugares;
    
    private int idRodado;

	public LugarPermisoPeriodoModel() {
		super();
	}
	public LugarPermisoPeriodoModel(PermisoPeriodoModel permisoPeriodo, int idPermisoPeriodo, int idPedido,
			int idLugarDesde, int idLugarHasta, Set<LugarModel> lstLugares, int idRodado) {
		super();
		this.permisoPeriodo = permisoPeriodo;
		this.idPermisoPeriodo = idPermisoPeriodo;
		this.idPedido = idPedido;
		this.idLugarDesde = idLugarDesde;
		this.idLugarHasta = idLugarHasta;
		this.lstLugares = lstLugares;
		this.idRodado = idRodado;
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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

	public Set<LugarModel> getLstLugares() {
		return lstLugares;
	}

	public void setLstLugares(Set<LugarModel> lstLugares) {
		this.lstLugares = lstLugares;
	}
	public PermisoPeriodoModel getPermisoPeriodo() {
		return permisoPeriodo;
	}
	public void setPermisoPeriodo(PermisoPeriodoModel permisoPeriodo) {
		this.permisoPeriodo = permisoPeriodo;
	}
	public int getIdPermisoPeriodo() {
		return idPermisoPeriodo;
	}
	public void setIdPermisoPeriodo(int idPermisoPeriodo) {
		this.idPermisoPeriodo = idPermisoPeriodo;
	}
	public int getIdRodado() {
		return idRodado;
	}
	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}


}
