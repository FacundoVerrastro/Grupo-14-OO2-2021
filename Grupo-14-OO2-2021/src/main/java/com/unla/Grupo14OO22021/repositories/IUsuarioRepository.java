package com.unla.Grupo14OO22021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo14OO22021.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	public abstract Usuario findByIdUsuario(int idUsuario);
	
	public abstract Usuario findByNumeroDocumento(int numeroDocumento);
	
	public abstract List<Usuario> findAll();
	
	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfil WHERE u.username = (:username)")
	public abstract Usuario findByNomUsuarioAndFetchIdPerfilEagerly(@Param("username") String username);
}
