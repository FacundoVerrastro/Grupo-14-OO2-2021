package com.unla.Grupo14OO22021.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.unla.Grupo14OO22021.converters.PerfilConverter;
import com.unla.Grupo14OO22021.converters.PermisoDiarioConverter;
import com.unla.Grupo14OO22021.converters.UsuarioConverter;
import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.FiltroModel;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.models.LugarPermisoDiarioModel;
import com.unla.Grupo14OO22021.models.PermisoDiarioModel;
import com.unla.Grupo14OO22021.models.UsuarioModel;
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
		
		//Usado para los filtros
		mAV.addObject("filtro", new FiltroModel());
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
	
	@GetMapping(value = "traerPorPersona/{idPersona}")
	public String traerPorPersona(@PathVariable int idPersona,Model model) {
		model.addAttribute("permisosDiarios",permisoDiarioRepository.findByIdUsuario(idPersona));
		model.addAttribute("permisoDiario", new PermisoDiarioModel());
		
		//Usado para validar el permiso
		model.addAttribute("fechaActual",LocalDate.now());
		model.addAttribute("checkActivates", false);
		
		//Usado para el traer por persona
		model.addAttribute("lstUsuarios",usuarioService.getAll());
		model.addAttribute("persona", new UsuarioModel());
		
		//Usado para los filtros
		model.addAttribute("filtro", new FiltroModel());
		
		return "permiso/traerPermisoDiario";
	}
	
	@GetMapping(value = "traerEntreFechas/{primeraFecha}&{segundaFecha}")
	public String traerEntreFechas(@PathVariable String primeraFecha,@PathVariable String segundaFecha,Model model) {
		LocalDate primeraFechaAux = LocalDate.parse(primeraFecha);
		LocalDate segundaFechaAux = LocalDate.parse(segundaFecha);
		model.addAttribute("permisosDiarios",permisoDiarioRepository.findBetweenDates(primeraFechaAux, segundaFechaAux));
		model.addAttribute("permisoDiario", new PermisoDiarioModel());
		
		FiltroModel filtro = new FiltroModel();
		model.addAttribute("filtro",filtro);
		
		//Usado para validar el permiso
		model.addAttribute("fechaActual",LocalDate.now());
		model.addAttribute("checkActivates", true);
		
		//Usado para el traer por persona
		model.addAttribute("lstUsuarios",usuarioService.getAll());
		model.addAttribute("persona", new UsuarioModel());
		
		//Usado para los filtros
		model.addAttribute("filtro", new FiltroModel());
		return "permiso/traerPermisoDiario";
	}
	@GetMapping(value = "traerEntreFechasYLugar/{primeraFecha}&{segundaFecha}&{idLugar}")
	public String traerEntreFechasYLugar(@PathVariable String primeraFecha,@PathVariable String segundaFecha,@PathVariable int idLugar,Model model) {
		LocalDate primeraFechaAux = LocalDate.parse(primeraFecha);
		LocalDate segundaFechaAux = LocalDate.parse(segundaFecha);
		model.addAttribute("permisosDiarios",permisoDiarioRepository.findBetweenDatesAndPlace(primeraFechaAux, segundaFechaAux,lugarRepository.findByIdLugar(idLugar)));
		model.addAttribute("permisoDiario", new PermisoDiarioModel());
		
		FiltroModel filtro = new FiltroModel();
		model.addAttribute("filtro",filtro);
		
		//Usado para validar el permiso
		model.addAttribute("fechaActual",LocalDate.now());
		model.addAttribute("checkActivates", true);
		
		//Usado para el traer por persona
		model.addAttribute("lstUsuarios",usuarioService.getAll());
		model.addAttribute("persona", new UsuarioModel());
		
		//Usado para los filtros
		model.addAttribute("filtro", new FiltroModel());
		return "permiso/traerPermisoDiario";
	}
	@PostMapping("/permisoDiario")
	public RedirectView create (@ModelAttribute("lugarPermisoDiario") LugarPermisoDiarioModel lugarPermisoDiarioModel){
		
		Usuario pedido = usuarioRepository.findById(lugarPermisoDiarioModel.getIdPedido()).orElse(null);
		
		Lugar lugarDesde = lugarRepository.findByIdLugar(lugarPermisoDiarioModel.getIdLugarDesde());
		Lugar lugarHasta = lugarRepository.findByIdLugar(lugarPermisoDiarioModel.getIdLugarHasta());
		
		PermisoDiarioModel permisoDiario = lugarPermisoDiarioModel.getPermisoDiario();
		permisoDiario.setDesdeHasta(new HashSet<LugarModel>());
		permisoDiario.setPedido(usuarioConverter.entityToModel(pedido));
		
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
	@PostMapping(value = "/buscarPorPersona/")
	public String buscarPorPersona(@ModelAttribute("filtro") FiltroModel filtroModel) {
		return "redirect:/permisos/traerPorPersona/"+filtroModel.getIdUsuario();
	}
	@PostMapping(value = "/buscarEntreFechas")
	public String buscarEntreFechas(@ModelAttribute("filtro") FiltroModel filtroModel ) {
		return "redirect:/permisos/traerEntreFechas/"+filtroModel.getPrimeraFecha()+"&"+filtroModel.getSegundaFecha();
	}
	@PostMapping(value = "/buscarEntreFechasYLugar")
	public String buscarEntreFechasYLugar(@ModelAttribute("filtro") FiltroModel filtroModel ) {
		return "redirect:/permisos/traerEntreFechasYLugar/"+filtroModel.getPrimeraFecha()+"&"+filtroModel.getSegundaFecha()+"&"+filtroModel.getIdLugarDeterminado();
	}
}
