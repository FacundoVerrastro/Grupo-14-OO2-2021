package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.Lugar;

@Repository("lugarRepository")
public interface ILugarRepository extends JpaRepository<Lugar, Serializable>{
	
	public abstract Lugar findByIdLugar(int idLugar);
	
	public abstract Lugar findByLugar(String lugar);
	
	public abstract List<Lugar> findAll();
	
}
