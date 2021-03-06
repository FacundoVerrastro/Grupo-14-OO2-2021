package com.unla.Grupo14OO22021.models;

import java.time.LocalDate;
import java.util.Set;

public class PermisoPeriodoModel extends PermisoModel {
	
	public Set<LugarModel> desdeHasta; 
	private int cantDias;
	private boolean vacaciones;
	private RodadoModel rodado;
	
	
	public PermisoPeriodoModel() {
		super();
	}
	
	

	public PermisoPeriodoModel(int idPermiso, UsuarioModel pedido, LocalDate fecha, Set<LugarModel> desdeHasta,
			int cantDias, boolean vacaciones, RodadoModel rodado) {
		super(idPermiso, pedido, fecha);
		this.desdeHasta = desdeHasta;
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public RodadoModel getRodado() {
		return rodado;
	}

	public void setRodado(RodadoModel rodado) {
		this.rodado = rodado;
	}
	
	public Set<LugarModel> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<LugarModel> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	@Override
	public String toString() {
		return "PermisoPeriodoModel [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha
				+", cantDias=" + cantDias + ", vacaciones=" + vacaciones + ", rodado="
				+ rodado + "]";
	}
	
	
}
