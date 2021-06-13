package com.unla.Grupo14OO22021.models;

public class LugarModel {
	private int idLugar;
	private String lugar;
	private String codPostal;
	
	
	public LugarModel() {
		super();
	}
	public LugarModel(int idLugar, String lugar, String codPostal) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codPostal = codPostal;
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
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	@Override
	public String toString() {
		return "LugarModel [idLugar=" + idLugar + ", lugar=" + lugar + ", codPostal=" + codPostal + "]";
	}
	
	
}
