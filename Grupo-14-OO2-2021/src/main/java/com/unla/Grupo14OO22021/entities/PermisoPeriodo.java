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
	public Set<Lugar> desdeHasta;
	
	@Column(name = "cantDias")
	public int cantDias;

	@Column(name = "vacaciones")
	public boolean vacaciones;
	
	@ManyToOne (fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn (name="idRodado",nullable=false)
	public Rodado rodado;

	public PermisoPeriodo() {
		super();
	}
	
	

	public PermisoPeriodo(int idPermiso, Usuario pedido, LocalDate fecha, Set<Lugar> desdeHasta, int cantDias,
			boolean vacaciones, Rodado rodado) {
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

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}



	@Override
	public String toString() {
		return "PermisoPeriodo [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha + ", desdeHasta="
				+ desdeHasta + ", cantDias=" + cantDias + ", vacaciones=" + vacaciones + ", rodado=" + rodado + "]";
	}
	
	
}
