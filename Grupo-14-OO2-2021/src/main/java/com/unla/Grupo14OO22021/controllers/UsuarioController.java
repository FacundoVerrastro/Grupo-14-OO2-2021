package com.unla.Grupo14OO22021.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo14OO22021.models.UsuarioModel;
import com.unla.Grupo14OO22021.services.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")//decia usuario controller
	private IUsuarioService usuarioService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView("usuario/index");
		mAV.addObject("usuarios", usuarioService.getAll());
		mAV.addObject("usuario", new UsuarioModel());
		return mAV;
	}

	@PostMapping("/")
	public RedirectView create (@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		usuarioService.insertOrUpdate(usuarioModel);
		return new RedirectView("home/index");
	}
}