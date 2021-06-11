package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.PermisoPeriodo;
import com.unla.Grupo14OO22021.entities.Rodado;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable> {

	public abstract PermisoPeriodo findByIdPermiso(int idPermiso);
	
	public abstract PermisoPeriodo findByRodado(Rodado rodado);
	
	public abstract List<PermisoPeriodo> findAll();
	
}
