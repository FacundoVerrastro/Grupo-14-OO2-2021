package com.unla.Grupo14OO22021.controllers;

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

import com.unla.Grupo14OO22021.entities.Rodado;
import com.unla.Grupo14OO22021.models.RodadoModel;
import com.unla.Grupo14OO22021.repositories.IRodadoRepository;
import com.unla.Grupo14OO22021.services.IRodadoService;

@Controller
@RequestMapping("/rodados")
public class RodadoController {
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService rodadoService;
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView("rodado/index");
		mAV.addObject("rodados", rodadoService.getAll());
		mAV.addObject("rodado", new RodadoModel());
		return mAV;
	}
	@GetMapping(value="/editar/{id}")
	public String modificarRodado(@PathVariable int id,Model model) {
		model.addAttribute(rodadoRepository.findById(id).orElse(null));
		return "rodado/modificarRodado";
	}
	
	@GetMapping(value = "/eliminarRodado/{id}")
	public String eliminar(@PathVariable int id) {
		rodadoService.remove(id);
		return "redirect:/rodados/";
	}
	
	@PostMapping("/")
	public RedirectView create (@ModelAttribute("rodado") RodadoModel rodadoModel) {
		rodadoService.insertOrUpdate(rodadoModel);
		return new RedirectView("");
	}
	@PostMapping(value = "/editarRodado/")
	public String update (@ModelAttribute Rodado rodado) {
		rodadoRepository.saveAndFlush(rodado);
		return "redirect:/rodados/";
	}
}
