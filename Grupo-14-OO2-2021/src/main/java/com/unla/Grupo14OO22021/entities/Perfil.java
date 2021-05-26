package com.unla.Grupo14OO22021.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;

	@Column (name= "tipo", nullable = false)
	private String tipo;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "perfil")
	private Set<Usuario> usuarios = new HashSet<Usuario>();

}
