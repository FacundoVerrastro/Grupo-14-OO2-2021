package com.unla.Grupo14OO22021.entities;

import javax.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombre", nullable=false)
    private String nombre;
	
	@Column(name="apellido", nullable=false)
    private String apellido;
	
	@Column(name="tipoDocumento", nullable=false)
    private String tipoDocumento;
	
	@Column(name="numeroDocumento", nullable=false)
    private int numeroDocumento;
	
	@Column(name="email", nullable=false)
    private String email;
	
	@Column(name="nomUsuario", nullable=false)
    private String nomUsuario;
	
	@Column(name="contraseña", nullable=false)
    private String contraseña;
	
	@ManyToOne
	@JoinColumn (name="idPerfil")
    private Perfil perfil;
}
