package com.unla.Grupo14OO22021.models;


public class LugarPermisoDiarioModel {
	
	private PermisoDiarioModel permisoDiario;
	
	private int idPedido;
	
    private int idLugarDesde;

    private int idLugarHasta;

	public LugarPermisoDiarioModel() {
		super();
	}

	public LugarPermisoDiarioModel(PermisoDiarioModel permisoDiario,int idPedido, int idLugarDesde, int idLugarHasta) {
		super();
		this.permisoDiario = permisoDiario;
		this.idPedido = idPedido;
		this.idLugarDesde = idLugarDesde;
		this.idLugarHasta = idLugarHasta;
	}
	
	public PermisoDiarioModel getPermisoDiario() {
		return permisoDiario;
	}

	public void setPermisoDiario(PermisoDiarioModel permisoDiario) {
		this.permisoDiario = permisoDiario;
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

	
}
