package com.unla.Grupo14OO22021.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo14OO22021.converters.LugarConverter;
import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.LugarPermisoDiario;
import com.unla.Grupo14OO22021.entities.PermisoDiario;
import com.unla.Grupo14OO22021.entities.PermisoPeriodo;
import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.models.LugarPermisoDiarioModel;
import com.unla.Grupo14OO22021.models.PermisoDiarioModel;
import com.unla.Grupo14OO22021.models.PermisoPeriodoModel;
import com.unla.Grupo14OO22021.models.UsuarioModel;
import com.unla.Grupo14OO22021.repositories.ILugarPermisoDiarioRepository;
import com.unla.Grupo14OO22021.repositories.ILugarRepository;
import com.unla.Grupo14OO22021.repositories.IPermisoDiarioRepository;
import com.unla.Grupo14OO22021.repositories.IPermisoPeriodoRepository;
import com.unla.Grupo14OO22021.repositories.IUsuarioRepository;
import com.unla.Grupo14OO22021.services.ILugarPermisoDiarioService;
import com.unla.Grupo14OO22021.services.ILugarService;
import com.unla.Grupo14OO22021.services.IPermisoDiarioService;
import com.unla.Grupo14OO22021.services.IPermisoPeriodoService;
import com.unla.Grupo14OO22021.services.IRodadoService;
import com.unla.Grupo14OO22021.services.IUsuarioService;

@Controller
@RequestMapping("/permisos")
public class PermisoDiarioController {

	//PERMISOS DIARIOS
	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;
	
	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Autowired
	@Qualifier("lugarPermisoDiarioRepository")
	private ILugarPermisoDiarioRepository lugarPermisoDiarioRepository;
	
	@Autowired
	@Qualifier("lugarPermisoDiarioService")
	private ILugarPermisoDiarioService lugarPermisoDiarioService;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
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
	@Qualifier("rodadoService")
	private IRodadoService rodadoService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView("permiso/indexPermisoDiario");
		mAV.addObject("permisosDiarios", permisoDiarioService.getAll());
		mAV.addObject("permisoDiario", new PermisoDiarioModel());
		mAV.addObject("lugarPermisoDiario", new LugarPermisoDiarioModel());
		mAV.addObject("lstUsuarios",usuarioService.getAll());
		mAV.addObject("lstLugares",lugarPermisoDiarioService.getAll());
		mAV.addObject("lstAlllugares",lugarService.getAll());
		return mAV;
	}
//	@GetMapping(value="/editarPermisoDiario/{id}")
//	public String modificarPermisoDiarioPermisoDiario(@PathVariable int id,Model model) {
//		model.addAttribute(permisoDiarioRepository.findById(id).orElse(null));
//		return "permiso/modificarPermisoDiario";
//	}
	@GetMapping(value="/editarPermisoDiario/{id}")
	public String modificarPermisoDiarioPermisoDiario(@PathVariable int id,Model model) {
		model.addAttribute(permisoDiarioRepository.findById(id).orElse(null));
		return "permiso/modificarPermisoDiario";
	}
	
	@GetMapping(value = "/eliminarPermisoDiario/{id}")
	public String eliminarPermisoDiario(@PathVariable int id) {
		permisoDiarioService.remove(id);
		return "redirect:/permisos/";
	}
	
	
	@PostMapping("/permisoDiario")
	public RedirectView create (@ModelAttribute("lugarPermisoDiario") LugarPermisoDiarioModel lugarPermisoDiarioModel){
		System.out.println(lugarPermisoDiarioModel.getIdLugarPermiso());
		System.out.println(lugarPermisoDiarioModel.getPermisoDiario().getMotivo());
		System.out.println(lugarPermisoDiarioModel.getPermisoDiario().getFecha());
		System.out.println(lugarPermisoDiarioModel.getLugar().getLugar());
		System.out.println(lugarPermisoDiarioModel.getLugar().getCodPostal());
		return new RedirectView("/permisos/");
	}
	@PostMapping(value = "/editarUsuario/")
	public String update (@ModelAttribute Usuario usuario) {
		usuarioRepository.saveAndFlush(usuario);
		return "redirect:/permisos/";
	}
	
	//PERMISOS PERIODO
	
	@GetMapping(value="/editarPermisoPeriodo/{id}")
	public String modificarPermisoPeriodo(@PathVariable int id,Model model) {
		model.addAttribute(permisoPeriodoRepository.findById(id).orElse(null));
		return "permiso/modificarPermisoPeriodo";
	}
	
	@GetMapping(value = "/eliminarPermisoPeriodo/{id}")
	public String eliminarPermisoPeriodo(@PathVariable int id) {
		permisoPeriodoService.remove(id);
		return "redirect:/permisos/";
	}
	
	@PostMapping("/permisoPeriodo")
	public RedirectView createPermisoPeriodo (@ModelAttribute("permisoPeriodo") PermisoPeriodoModel permisoPeriodoModel) {
		permisoPeriodoService.insertOrUpdate(permisoPeriodoModel);
		return new RedirectView("");
	}
	@PostMapping(value = "/editarPermisoPeriodo/")
	public String updatePermisoPeriodo (@ModelAttribute PermisoPeriodo permisoPeriodo) {
		permisoPeriodoRepository.saveAndFlush(permisoPeriodo);
		return "redirect:/perfiles/";
	}
}
