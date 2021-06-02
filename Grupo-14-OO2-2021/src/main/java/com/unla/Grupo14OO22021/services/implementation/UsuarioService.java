package com.unla.Grupo14OO22021.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.Grupo14OO22021.converters.UsuarioConverter;
import com.unla.Grupo14OO22021.entities.Perfil;
import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.UsuarioModel;
import com.unla.Grupo14OO22021.repositories.IUsuarioRepository;
import com.unla.Grupo14OO22021.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService, UserDetailsService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Override
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	};
	
	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel) {
		Usuario usuario = usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModel));
		return usuarioConverter.entityToModel(usuario);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			usuarioRepository.delete(usuarioRepository.findByIdUsuario(id));
			//usuarioRepository.deleteById;
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@Override	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario usuario = usuarioRepository.findByNomUsuarioAndFetchIdPerfilEagerly(username);
//		System.out.println(usuario);
		return buildUsuario(usuario, buildGrantedAuthorities(usuario.getPerfil()));
	}
	
	public User buildUsuario(Usuario usuario, List<GrantedAuthority> grantedAuthorities) {
		return new User(usuario.getNomUsuario(),usuario.getPassword(),true,true,true,true,grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Perfil perfil) {
		Set<GrantedAuthority> grantedAuthority = new HashSet<GrantedAuthority>();
		grantedAuthority.add(new SimpleGrantedAuthority(perfil.getTipo()));
//		System.out.println(grantedAuthority);
		return new ArrayList<GrantedAuthority>(grantedAuthority);
	}
	
}