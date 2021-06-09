package com.unla.Grupo14OO22021.models;

public class UsuarioModel {
	private int idUsuario;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private int numeroDocumento;
    private String email;
    private String nomUsuario;
    private String password;
    private PerfilModel perfil;
    
    public UsuarioModel() {
        super();
    }
    
    public UsuarioModel(int idUsuario, String nombre, String apellido, String tipoDocumento, int numeroDocumento,
			String email, String nomUsuario, String password) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.email = email;
		this.nomUsuario = nomUsuario;
		this.password = password;
	}

	public UsuarioModel(int idUsuario, String nombre, String apellido,
            String tipoDocumento, int numeroDocumento, String email,
            String nomUsuario, String contraseña, PerfilModel perfil) {
        super();
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.nomUsuario = nomUsuario;
        this.password = contraseña;
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
	public PerfilModel getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UsuarioModel [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", email=" + email
				+ ", nomUsuario=" + nomUsuario + ", password=" + password + ", perfil=" + perfil + "]";
	}
    
    
}
