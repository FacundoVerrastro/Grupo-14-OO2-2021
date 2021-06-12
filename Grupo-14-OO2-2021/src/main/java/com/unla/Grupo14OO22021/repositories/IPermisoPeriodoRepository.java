package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.PermisoPeriodo;
import com.unla.Grupo14OO22021.entities.Rodado;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable> {

	public abstract PermisoPeriodo findByIdPermiso(int idPermiso);
	
	public abstract List<PermisoPeriodo> findAll();
	
	@Query("SELECT q FROM PermisoPeriodo q WHERE q.pedido.idUsuario = (:idUsuario)")
	public abstract List<PermisoPeriodo> findByIdUsuario(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT q FROM PermisoPeriodo q WHERE (:rodado) = q.rodado")
	public abstract List<PermisoPeriodo> findByRodado(@Param("rodado") Rodado rodado);
	
	@Query("SELECT q FROM PermisoPeriodo q WHERE q.fecha BETWEEN (:primeraFecha) AND (:segundaFecha)")
	public abstract List<PermisoPeriodo> findBetweenDates(@Param("primeraFecha") LocalDate primeraFecha,@Param("segundaFecha") LocalDate segundaFecha );
	
	@Query("SELECT q FROM PermisoPeriodo q WHERE (:lugar) member of q.desdeHasta AND q.fecha BETWEEN (:primeraFecha) AND (:segundaFecha)")
	public abstract List<PermisoPeriodo> findBetweenDatesAndPlace(@Param("primeraFecha") LocalDate primeraFecha,@Param("segundaFecha") LocalDate segundaFecha,
			@Param("lugar") Lugar lugar);
}
