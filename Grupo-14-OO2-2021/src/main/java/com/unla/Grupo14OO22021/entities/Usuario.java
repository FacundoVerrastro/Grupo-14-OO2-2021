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

	
	
	public Usuario() {
		super();
	}



	public Usuario(int idUsuario, String nombre, String apellido, String tipoDocumento, int numeroDocumento,
			String email, String nomUsuario, String contraseña, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.email = email;
		this.nomUsuario = nomUsuario;
		this.contraseña = contraseña;
		this.perfil = perfil;
	}



	public int getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getTipoDocumento() {
		return tipoDocumento;
	}



	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



	public int getNumeroDocumento() {
		return numeroDocumento;
	}



	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNomUsuario() {
		return nomUsuario;
	}



	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}



	public String getContraseña() {
		return contraseña;
	}



	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	public Perfil getPerfil() {
		return perfil;
	}



	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
	
}
