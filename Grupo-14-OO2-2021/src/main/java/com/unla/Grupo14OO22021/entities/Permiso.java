package com.unla.Grupo14OO22021.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@MappedSuperclass
public class Permiso {
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    protected int idPermiso;
	 
	    @ManyToOne (fetch = FetchType.LAZY)
	    @JoinColumn (name="idUsuario")
	    protected Usuario pedido;

	    @Column(name = "fecha")
	    protected LocalDate fecha;
	    
		public Permiso() {
			super();
		}
		
		public Permiso(Usuario pedido, LocalDate fecha) {
			super();
			this.pedido = pedido;
			this.fecha = fecha;
		}

		public Permiso(int idPermiso, Usuario pedido, LocalDate fecha) {
			super();
			this.idPermiso = idPermiso;
			this.pedido = pedido;
			this.fecha = fecha;
		}


		public int getIdPermiso() {
			return idPermiso;
		}


		public void setIdPermiso(int idPermiso) {
			this.idPermiso = idPermiso;
		}


		public Usuario getPedido() {
			return pedido;
		}


		public void setPedido(Usuario pedido) {
			this.pedido = pedido;
		}


		public LocalDate getFecha() {
			return fecha;
		}


		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
		
}
