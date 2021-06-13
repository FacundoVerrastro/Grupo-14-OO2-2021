package com.unla.Grupo14OO22021.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class FiltroModel {
	
	private int idUsuario;
	private int idRodado;
	private LocalDate primeraFecha;
	private LocalDate segundaFecha;
	private int idLugarDeterminado;
	public FiltroModel() {
		super();
	}
	public FiltroModel(int idUsuario, int idRodado, LocalDate primeraFecha, LocalDate segundaFecha,
			int idLugarDeterminado) {
		super();
		this.idUsuario = idUsuario;
		this.idRodado = idRodado;
		this.primeraFecha = primeraFecha;
		this.segundaFecha = segundaFecha;
		this.idLugarDeterminado = idLugarDeterminado;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdRodado() {
		return idRodado;
	}
	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getPrimeraFecha() {
		return primeraFecha;
	}
	public void setPrimeraFecha(LocalDate primeraFecha) {
		this.primeraFecha = primeraFecha;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getSegundaFecha() {
		return segundaFecha;
	}
	public void setSegundaFecha(LocalDate segundaFecha) {
		this.segundaFecha = segundaFecha;
	}
	public int getIdLugarDeterminado() {
		return idLugarDeterminado;
	}
	public void setIdLugarDeterminado(int idLugarDeterminado) {
		this.idLugarDeterminado = idLugarDeterminado;
	}
	@Override
	public String toString() {
		return "FiltroModel [idUsuario=" + idUsuario + ", idRodado=" + idRodado + ", primeraFecha=" + primeraFecha
				+ ", segundaFecha=" + segundaFecha + ", idLugarDeterminado=" + idLugarDeterminado + "]";
	}
}
