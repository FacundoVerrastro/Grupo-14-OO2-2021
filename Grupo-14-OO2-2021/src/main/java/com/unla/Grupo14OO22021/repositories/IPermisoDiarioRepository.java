package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.PermisoDiario;
import com.unla.Grupo14OO22021.entities.Usuario;

@Repository("permisoDiarioRepository")
public interface IPermisoDiarioRepository extends JpaRepository<PermisoDiario, Serializable> {
	
	public abstract PermisoDiario findByIdPermiso(int idPermiso);
	
	public abstract PermisoDiario findByMotivo(String motivo);
	
	public abstract List<PermisoDiario> findAll();
	
	
//	@Query("SELECT l FROM Lugar l JOIN FETCH p1.desdeHasta WHERE p1.idPermiso = (:idPermiso)")
//    List<Lugar> findAllByPermisoDiario(String idPermiso);	
	
}
