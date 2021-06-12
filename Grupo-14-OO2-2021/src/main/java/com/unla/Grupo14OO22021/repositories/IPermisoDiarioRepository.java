package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.PermisoDiario;

@Repository("permisoDiarioRepository")
public interface IPermisoDiarioRepository extends JpaRepository<PermisoDiario, Serializable> {
	
	public abstract PermisoDiario findByIdPermiso(int idPermiso);
	
	public abstract PermisoDiario findByMotivo(String motivo);
	
	public abstract List<PermisoDiario> findAll();	
	
	@Query("SELECT q FROM PermisoDiario q WHERE q.pedido.idUsuario = (:idUsuario)")
	public abstract List<PermisoDiario> findByIdUsuario(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT q FROM PermisoDiario q WHERE q.fecha BETWEEN (:primeraFecha) AND (:segundaFecha)")
	public abstract List<PermisoDiario> findBetweenDates(@Param("primeraFecha") LocalDate primeraFecha,@Param("segundaFecha") LocalDate segundaFecha );
	
	@Query("SELECT q FROM PermisoDiario q WHERE (:lugar) member of q.desdeHasta AND q.fecha BETWEEN (:primeraFecha) AND (:segundaFecha)")
	public abstract List<PermisoDiario> findBetweenDatesAndPlace(@Param("primeraFecha") LocalDate primeraFecha,@Param("segundaFecha") LocalDate segundaFecha,
			@Param("lugar") Lugar lugar);
}
