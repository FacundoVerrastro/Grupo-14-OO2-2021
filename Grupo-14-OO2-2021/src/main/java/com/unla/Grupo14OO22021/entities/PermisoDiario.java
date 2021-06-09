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
import javax.persistence.Table;

@Entity
@Table(name = "PermisoDiario")
public class PermisoDiario extends Permiso{
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinTable(
			  name = "permiso_diario_desde_hasta", 
			  joinColumns = @JoinColumn(name = "permiso_id"), 
			  inverseJoinColumns = @JoinColumn(name = "lugar_id"))
	public Set<Lugar> desdeHasta;
	
	@Column(name = "motivo")
	public String motivo;
	
	
	public PermisoDiario() {
		super();
	}
	
	
	public PermisoDiario(Usuario pedido, LocalDate fecha, String motivo) {
		super(pedido, fecha);
		this.motivo = motivo;
	}


	public PermisoDiario(int idPermiso, Usuario pedido, LocalDate fecha, String motivo) {
		super(idPermiso, pedido, fecha);
		this.motivo = motivo;
	}
	



	public PermisoDiario(int idPermiso, Usuario pedido, LocalDate fecha, Set<Lugar> desdeHasta, String motivo) {
		super(idPermiso, pedido, fecha);
		this.desdeHasta = desdeHasta;
		this.motivo = motivo;
	}


	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}


	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}


	@Override
	public String toString() {
		return "PermisoDiario [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha + ", motivo="
				+ motivo + "]";
	}
	
	
}
