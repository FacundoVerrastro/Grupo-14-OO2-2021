package com.unla.Grupo14OO22021.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "usuario", uniqueConstraints=@UniqueConstraint(columnNames= {"idPerfil"}))
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
	
	@Column(name="nomUsuario",unique=true, nullable=false)
    private String nomUsuario;
	
	@Column(name="password", nullable=false, length=60)
    private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name="idPerfil")
    private Perfil perfil;
	
	public Usuario() {
		super();
	}



	public Usuario(int idUsuario, String nombre, String apellido, String tipoDocumento, int numeroDocumento,
			String email, String nomUsuario, String password, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.email = email;
		this.nomUsuario = nomUsuario;
		this.password = password;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	

	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public Perfil getPerfil() {
		return perfil;
	}



	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}



	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento="
				+ tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", email=" + email + ", nomUsuario="
				+ nomUsuario + ", password=" + password + ", enabled=" + enabled + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", perfil=" + perfil + "]";
	}
	
	
	
}
