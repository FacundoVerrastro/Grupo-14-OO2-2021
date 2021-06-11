package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.Rodado;

@Repository("rodadoRepository")
public interface IRodadoRepository extends JpaRepository<Rodado, Serializable>{

	public abstract Rodado findByIdRodado(int idRodado);
	
	public abstract Rodado findByDominio(String dominio);
	
	public abstract List<Rodado> findAll();
	
}
