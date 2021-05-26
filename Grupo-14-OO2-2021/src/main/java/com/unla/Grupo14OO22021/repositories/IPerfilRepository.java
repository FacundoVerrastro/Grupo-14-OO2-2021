package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.Perfil;

@Repository("perfilRepository")
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable>{
	
	public abstract Perfil findByIdPerfil(int idPerfil);
	
	public abstract Perfil findByTipo(String tipo);
	
	public abstract List<Perfil> findAll();
	
	
}
