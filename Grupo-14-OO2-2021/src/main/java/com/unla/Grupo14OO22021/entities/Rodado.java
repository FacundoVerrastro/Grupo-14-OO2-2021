package com.unla.Grupo14OO22021.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rodado")
public class Rodado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRodado;
	
	@Column(name="dominio", nullable=false)
    private String dominio;
	
	@Column(name="vehiculo", nullable=false)
    private String vehiculo;

	public Rodado() {
		super();
	}

	public Rodado(int idRodado, String dominio, String vehiculo) {
		super();
		this.idRodado = idRodado;
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
}
