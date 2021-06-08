package com.unla.Grupo14OO22021.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PermisoPeriodo")
public class PermisoPeriodo extends Permiso {
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinTable(
			  name = "permiso_periodo_desde_hasta", 
			  joinColumns = @JoinColumn(name = "permiso_id"), 
			  inverseJoinColumns = @JoinColumn(name = "lugar_id"))
	private Set<Lugar> desdeHasta;
	
	@Column(name = "cantDias")
	private int cantDias;

	@Column(name = "vacaciones")
	private boolean vacaciones;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name="idRodado")
	private Rodado rodado;

	public PermisoPeriodo() {
		super();
	}
	
	public PermisoPeriodo(int idPermiso, Usuario pedido, LocalDate fecha, int cantDias,
			boolean vacaciones, Rodado rodado) {
		super(idPermiso, pedido, fecha);
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

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}
	
	
}
