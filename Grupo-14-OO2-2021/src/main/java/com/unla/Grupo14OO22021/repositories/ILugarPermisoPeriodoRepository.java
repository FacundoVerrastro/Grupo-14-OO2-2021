package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.LugarPermisoPeriodo;

@Repository("lugarPermisoPeriodoRepository")
public interface ILugarPermisoPeriodoRepository  extends JpaRepository<LugarPermisoPeriodo, Serializable>{

	public abstract LugarPermisoPeriodo findByIdLugarPermiso(int idLugarPermiso);
	
	public abstract List<LugarPermisoPeriodo> findAllByPermisoPeriodo(int idPermisoPeriodo);
	
	public abstract List<LugarPermisoPeriodo> findAll();
	
}
