package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.LugarPermisoDiario;

@Repository("lugarPermisoDiarioRepository")
public interface ILugarPermisoDiarioRepository extends JpaRepository<LugarPermisoDiario, Serializable>{
	
	public abstract LugarPermisoDiario findByIdLugarPermiso(int idLugarPermiso);
	
	public abstract List<LugarPermisoDiario> findAllByPermisoDiario(int permisoDiario);
	
	public abstract List<LugarPermisoDiario> findAll();
	
}
