package com.unla.Grupo14OO22021.controllers;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo14OO22021.converters.LugarConverter;
import com.unla.Grupo14OO22021.converters.PerfilConverter;
import com.unla.Grupo14OO22021.converters.PermisoDiarioConverter;
import com.unla.Grupo14OO22021.converters.UsuarioConverter;
import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.models.LugarPermisoDiarioModel;
import com.unla.Grupo14OO22021.models.PermisoDiarioModel;
import com.unla.Grupo14OO22021.repositories.ILugarRepository;
import com.unla.Grupo14OO22021.repositories.IPerfilRepository;
import com.unla.Grupo14OO22021.repositories.IPermisoDiarioRepository;
import com.unla.Grupo14OO22021.repositories.IUsuarioRepository;
import com.unla.Grupo14OO22021.services.ILugarService;
import com.unla.Grupo14OO22021.services.IPermisoDiarioService;
import com.unla.Grupo14OO22021.services.IUsuarioService;

@Controller
@RequestMapping("/permisos")
public class PermisoDiarioController {

	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;
	
	@Autowired
	@Qualifier("permisoDiarioConverter")
	private PermisoDiarioConverter permisoDiarioConverter;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;
	
	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	
	@GetMapping("/permisosDiarios")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView("permiso/indexPermisoDiario");
		mAV.addObject("permisosDiarios", permisoDiarioService.getAll());
		mAV.addObject("permisoDiario", new PermisoDiarioModel());
		
		//Usados para el agregar PermisoDiario
		mAV.addObject("lugarPermisoDiario", new LugarPermisoDiarioModel());
		mAV.addObject("lstUsuarios",usuarioService.getAll());
		mAV.addObject("lstAllLugares",lugarService.getAll());
		
		//Usado para validar el permiso
		mAV.addObject("fechaActual",LocalDate.now());
		
		return mAV;
	}
	
	@GetMapping(value="/editarPermisoDiario/{id}")
	public String modificarPermisoDiario(@PathVariable int id,Model model) {
		
		LugarPermisoDiarioModel lugarPermisoDiario = new LugarPermisoDiarioModel();
		lugarPermisoDiario.setIdPermisoDiario(permisoDiarioRepository.findById(id).orElse(null).getIdPermiso());
		model.addAttribute("lugarPermisoDiario",lugarPermisoDiario);
		model.addAttribute("lstUsuarios",usuarioService.getAll());
		model.addAttribute("lstAllLugares",lugarService.getAll());
		
		return "permiso/modificarPermisoDiario";
	}
	
	@GetMapping(value = "/eliminarPermisoDiario/{id}")
	public String eliminarPermisoDiario(@PathVariable int id) {
		permisoDiarioService.remove(id);
		return "redirect:/permisos/permisosDiarios";
	}
	
	
	@PostMapping("/permisoDiario")
	public RedirectView create (@ModelAttribute("lugarPermisoDiario") LugarPermisoDiarioModel lugarPermisoDiarioModel){
		
		Usuario pedido = usuarioRepository.findById(lugarPermisoDiarioModel.getIdPedido()).orElse(null);
		
		Lugar lugarDesde = lugarRepository.findByIdLugar(lugarPermisoDiarioModel.getIdLugarDesde());
		Lugar lugarHasta = lugarRepository.findByIdLugar(lugarPermisoDiarioModel.getIdLugarHasta());
		
		PermisoDiarioModel permisoDiario = lugarPermisoDiarioModel.getPermisoDiario();
		permisoDiario.setDesdeHasta(new HashSet<LugarModel>());
		permisoDiario.setPedido(usuarioConverter.entityToModel(pedido));
		permisoDiario.setIdPermiso(lugarPermisoDiarioModel.getIdPedido());
		
		permisoDiario.getDesdeHasta().add(lugarConverter.entityToModel(lugarDesde));
		permisoDiario.getDesdeHasta().add(lugarConverter.entityToModel(lugarHasta));
		
		permisoDiarioService.insertOrUpdate(permisoDiario);
		
		return new RedirectView("/permisos/permisosDiarios");
	}
	@PostMapping(value = "/editarPermisoDiario/")
	public String update (@ModelAttribute ("lugarPermisoDiario") LugarPermisoDiarioModel lugarPermisoDiarioModel) {
		
		Usuario pedido = usuarioRepository.findById(lugarPermisoDiarioModel.getIdPedido()).orElse(null);
		
		Lugar lugarDesde = lugarRepository.findByIdLugar(lugarPermisoDiarioModel.getIdLugarDesde());
		Lugar lugarHasta = lugarRepository.findByIdLugar(lugarPermisoDiarioModel.getIdLugarHasta());
		
		PermisoDiarioModel permisoDiario = lugarPermisoDiarioModel.getPermisoDiario();
		permisoDiario.setIdPermiso(lugarPermisoDiarioModel.getIdPermisoDiario());
		
		permisoDiario.setDesdeHasta(new HashSet<LugarModel>());
		
		permisoDiario.setPedido(usuarioConverter.entityToModel(pedido));
		
		permisoDiario.getDesdeHasta().add(lugarConverter.entityToModel(lugarDesde));
		permisoDiario.getDesdeHasta().add(lugarConverter.entityToModel(lugarHasta));
		
		permisoDiarioRepository.saveAndFlush(permisoDiarioConverter.modelToEntity(permisoDiario));
		
		return "redirect:/permisos/permisosDiarios";
	}
}
