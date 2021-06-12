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
import com.unla.Grupo14OO22021.converters.PermisoPeriodoConverter;
import com.unla.Grupo14OO22021.converters.RodadoConverter;
import com.unla.Grupo14OO22021.converters.UsuarioConverter;
import com.unla.Grupo14OO22021.entities.Lugar;
import com.unla.Grupo14OO22021.entities.Rodado;
import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.FiltroModel;
import com.unla.Grupo14OO22021.models.LugarModel;
import com.unla.Grupo14OO22021.models.LugarPermisoPeriodoModel;
import com.unla.Grupo14OO22021.models.PermisoDiarioModel;
import com.unla.Grupo14OO22021.models.PermisoPeriodoModel;
import com.unla.Grupo14OO22021.models.UsuarioModel;
import com.unla.Grupo14OO22021.repositories.ILugarRepository;
import com.unla.Grupo14OO22021.repositories.IPerfilRepository;
import com.unla.Grupo14OO22021.repositories.IPermisoPeriodoRepository;
import com.unla.Grupo14OO22021.repositories.IRodadoRepository;
import com.unla.Grupo14OO22021.repositories.IUsuarioRepository;
import com.unla.Grupo14OO22021.services.ILugarService;
import com.unla.Grupo14OO22021.services.IPermisoPeriodoService;
import com.unla.Grupo14OO22021.services.IRodadoService;
import com.unla.Grupo14OO22021.services.IUsuarioService;

@Controller
@RequestMapping("/permisos")
public class PermisoPeriodoController {
	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Autowired
	@Qualifier("permisoPeriodoConverter")
	private PermisoPeriodoConverter permisoPeriodoConverter;
	
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
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService rodadoService;
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;
	
	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;
	
	@GetMapping("/permisosPeriodos")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView("permiso/indexPermisoPeriodo");
		mAV.addObject("permisosPeriodos", permisoPeriodoService.getAll());
		mAV.addObject("permisoPeriodo", new PermisoPeriodoModel());
		
		//Usados para el agregar PemisoPeriodo
		mAV.addObject("lugarPermisoPeriodo", new LugarPermisoPeriodoModel());
		mAV.addObject("lstUsuarios",usuarioService.getAll());
		mAV.addObject("lstAllLugares",lugarService.getAll());
		mAV.addObject("lstRodados",rodadoService.getAll());
		
		//Usado para validar el permiso
		mAV.addObject("fechaActual",LocalDate.now());
		
		//Usado para los filtros
		mAV.addObject("filtro", new FiltroModel());
				
		return mAV;
	}
	
	@GetMapping(value="/editarPermisoPeriodo/{id}")
	public String modificarPermisoPeriodo(@PathVariable int id,Model model) {
		
		LugarPermisoPeriodoModel lugarPermisoPeriodo = new LugarPermisoPeriodoModel();
		lugarPermisoPeriodo.setPermisoPeriodo(permisoPeriodoConverter.entityToModel(permisoPeriodoRepository.findById(id).orElse(null)));
		lugarPermisoPeriodo.setIdPermisoPeriodo(permisoPeriodoRepository.findById(id).orElse(null).getIdPermiso());
		
		
		model.addAttribute("lugarPermisoPeriodo",lugarPermisoPeriodo);
		model.addAttribute("lstUsuarios",usuarioService.getAll());
		model.addAttribute("lstAllLugares",lugarService.getAll());
		model.addAttribute("lstRodados",rodadoService.getAll());
		
		return "permiso/modificarPermisoPeriodo";
	}
	
	@GetMapping(value = "/eliminarPermisoPeriodo/{id}")
	public String eliminarPermisoPeriodo(@PathVariable int id) {
		permisoPeriodoService.remove(id);
		return "redirect:/permisos/permisosPeriodos";
	}
	
	@GetMapping(value = "traerPorPersonaPeriodo/{idPersona}")
	public String traerPorPersonaPeriodo(@PathVariable int idPersona,Model model) {
		model.addAttribute("permisosPeriodos",permisoPeriodoRepository.findByIdUsuario(idPersona));
		model.addAttribute("permisoPeriodo", new PermisoPeriodoModel());
		
		model.addAttribute("lstRodados", rodadoService.getAll());
		model.addAttribute("lstAllLugares",lugarService.getAll());
		
		//Usado para validar el permiso
		model.addAttribute("fechaActual",LocalDate.now());
		model.addAttribute("checkActivates", false);
		
		//Usado para el traer por persona
		model.addAttribute("lstUsuarios",usuarioService.getAll());
		model.addAttribute("persona", new UsuarioModel());
		
		//Usado para los filtros
		model.addAttribute("filtro", new FiltroModel());
		
		return "permiso/traerPermisoPeriodo";
	}

	@GetMapping(value = "traerPorRodado/{idRodado}")
	public String traerPorRodado(@PathVariable int idRodado,Model model) {
		model.addAttribute("permisosPeriodos",permisoPeriodoRepository.findByRodado(rodadoRepository.findById(idRodado).orElse(null)));
		model.addAttribute("permisoPeriodo", new PermisoPeriodoModel());
		
		model.addAttribute("lstRodados", rodadoService.getAll());
		model.addAttribute("lstAllLugares",lugarService.getAll());
		
		//Usado para validar el permiso
		model.addAttribute("fechaActual",LocalDate.now());
		model.addAttribute("checkActivates", false);
		
		//Usado para el traer por persona
		model.addAttribute("lstUsuarios",usuarioService.getAll());
		model.addAttribute("persona", new UsuarioModel());
		
		//Usado para los filtros
		model.addAttribute("filtro", new FiltroModel());
		
		return "permiso/traerPermisoPeriodo";
	}
	@GetMapping(value = "traerEntreFechasPeriodo/{primeraFecha}&{segundaFecha}")
	public String traerEntreFechasPeriodo(@PathVariable String primeraFecha,@PathVariable String segundaFecha,Model model) {
		LocalDate primeraFechaAux = LocalDate.parse(primeraFecha);
		LocalDate segundaFechaAux = LocalDate.parse(segundaFecha);
		model.addAttribute("permisosPeriodos",permisoPeriodoRepository.findBetweenDates(primeraFechaAux, segundaFechaAux));
		model.addAttribute("permisoPeriodo", new PermisoDiarioModel());
		
		model.addAttribute("lstRodados", rodadoService.getAll());
		model.addAttribute("lstAllLugares",lugarService.getAll());
		
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
		return "permiso/traerPermisoPeriodo";
	}
	
	@GetMapping(value = "traerEntreFechasYLugarPeriodo/{primeraFecha}&{segundaFecha}&{idLugar}")
	public String traerEntreFechasYLugarPeriodo(@PathVariable String primeraFecha,@PathVariable String segundaFecha,@PathVariable int idLugar,Model model) {
		LocalDate primeraFechaAux = LocalDate.parse(primeraFecha);
		LocalDate segundaFechaAux = LocalDate.parse(segundaFecha);
		
		model.addAttribute("permisosPeriodos",permisoPeriodoRepository.findBetweenDatesAndPlace(primeraFechaAux, segundaFechaAux,lugarRepository.findByIdLugar(idLugar)));
		model.addAttribute("permisoPeriodo", new PermisoPeriodoModel());
		
		FiltroModel filtro = new FiltroModel();
		model.addAttribute("filtro",filtro);
		
		model.addAttribute("lstRodados", rodadoService.getAll());
		model.addAttribute("lstAllLugares",lugarService.getAll());
		
		//Usado para validar el permiso
		model.addAttribute("fechaActual",LocalDate.now());
		model.addAttribute("checkActivates", true);
		
		//Usado para el traer por persona
		model.addAttribute("lstUsuarios",usuarioService.getAll());
		model.addAttribute("persona", new UsuarioModel());
		
		//Usado para los filtros
		model.addAttribute("filtro", new FiltroModel());
		return "permiso/traerPermisoPeriodo";
	}
	
	@PostMapping("/permisoPeriodo/")
	public RedirectView create (@ModelAttribute("lugarPermisoPeriodo") LugarPermisoPeriodoModel lugarPermisoPeriodoModel){
		
		Usuario pedido = usuarioRepository.findById(lugarPermisoPeriodoModel.getIdPedido()).orElse(null);
		Rodado rodado = rodadoRepository.findById(lugarPermisoPeriodoModel.getIdRodado()).orElse(null);
		
		Lugar lugarDesde = lugarRepository.findByIdLugar(lugarPermisoPeriodoModel.getIdLugarDesde());
		Lugar lugarHasta = lugarRepository.findByIdLugar(lugarPermisoPeriodoModel.getIdLugarHasta());
		
		PermisoPeriodoModel permisoPeriodo = lugarPermisoPeriodoModel.getPermisoPeriodo();
		permisoPeriodo.setDesdeHasta(new HashSet<LugarModel>());
		permisoPeriodo.setPedido(usuarioConverter.entityToModel(pedido));
		permisoPeriodo.setRodado(rodadoConverter.entityToModel(rodado));
		
		permisoPeriodo.getDesdeHasta().add(lugarConverter.entityToModel(lugarDesde));
		permisoPeriodo.getDesdeHasta().add(lugarConverter.entityToModel(lugarHasta));
		
		permisoPeriodoService.insertOrUpdate(permisoPeriodo);
		
		return new RedirectView("/permisos/permisosPeriodos");
	}
	@PostMapping(value = "/editarPermisoPeriodo/")
	public String update (@ModelAttribute ("lugarPermisoPeriodo") LugarPermisoPeriodoModel lugarPermisoPeriodoModel) {
		
		Usuario pedido = usuarioRepository.findById(lugarPermisoPeriodoModel.getIdPedido()).orElse(null);
		Rodado rodado = rodadoRepository.findById(lugarPermisoPeriodoModel.getIdRodado()).orElse(null);
		
		Lugar lugarDesde = lugarRepository.findByIdLugar(lugarPermisoPeriodoModel.getIdLugarDesde());
		Lugar lugarHasta = lugarRepository.findByIdLugar(lugarPermisoPeriodoModel.getIdLugarHasta());
		
		PermisoPeriodoModel permisoPeriodo = lugarPermisoPeriodoModel.getPermisoPeriodo();
		
		permisoPeriodo.setDesdeHasta(new HashSet<LugarModel>());
		
		permisoPeriodo.setPedido(usuarioConverter.entityToModel(pedido));
		permisoPeriodo.setIdPermiso(lugarPermisoPeriodoModel.getIdPermisoPeriodo());
		
		permisoPeriodo.setRodado(rodadoConverter.entityToModel(rodado));
		
		permisoPeriodo.getDesdeHasta().add(lugarConverter.entityToModel(lugarDesde));
		permisoPeriodo.getDesdeHasta().add(lugarConverter.entityToModel(lugarHasta));
		
		permisoPeriodoRepository.saveAndFlush(permisoPeriodoConverter.modelToEntity(permisoPeriodo));
		
		return "redirect:/permisos/permisosPeriodos";
	}
	
	@PostMapping(value = "/buscarPorPersonaPeriodo/")
	public String buscarPorPersonaPeriodo(@ModelAttribute("filtro") FiltroModel filtroModel) {
		return "redirect:/permisos/traerPorPersonaPeriodo/"+filtroModel.getIdUsuario();
	}
	@PostMapping(value = "/buscarPorRodado/")
	public String buscarPorRodado(@ModelAttribute("filtro") FiltroModel filtroModel) {
		return "redirect:/permisos/traerPorRodado/"+filtroModel.getIdRodado();
	}
	@PostMapping(value = "/buscarEntreFechasPeriodo")
	public String buscarEntreFechasPeriodo(@ModelAttribute("filtro") FiltroModel filtroModel ) {
		return "redirect:/permisos/traerEntreFechasPeriodo/"+filtroModel.getPrimeraFecha()+"&"+filtroModel.getSegundaFecha();
	}
	@PostMapping(value = "/buscarEntreFechasYLugarPeriodo")
	public String buscarEntreFechasYLugarPeriodo(@ModelAttribute("filtro") FiltroModel filtroModel ) {
		return "redirect:/permisos/traerEntreFechasYLugarPeriodo/"+filtroModel.getPrimeraFecha()+"&"+filtroModel.getSegundaFecha()+"&"+filtroModel.getIdLugarDeterminado();
	}
}
