package com.unla.Grupo14OO22021.controllers;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lowagie.text.DocumentException;
import com.unla.Grupo14OO22021.Exporters.UsuariosPDFExporter;
import com.unla.Grupo14OO22021.converters.UsuarioConverter;
import com.unla.Grupo14OO22021.entities.Usuario;
import com.unla.Grupo14OO22021.models.UsuarioModel;
import com.unla.Grupo14OO22021.services.IPerfilService;
import com.unla.Grupo14OO22021.services.IUsuarioService;
import com.unla.Grupo14OO22021.repositories.IUsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")//decia usuario controller
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService perfilService;
	

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView("usuario/index");
		mAV.addObject("usuarios", usuarioService.getAll());
		mAV.addObject("usuario", new UsuarioModel());
		mAV.addObject("lstPerfiles",perfilService.getAll());
		return mAV;
	}

	@GetMapping(value="/editar/{id}")
	public String modificarUsuario(@PathVariable int id,Model model) {
//		ModelAndView mAV = new ModelAndView("usuario/modificarUsuario");
//		mAV.addObject("usuarios", usuarioRepository.findById(id));
//		mAV.addObject("usuario", usuarioConverter.entityToModel(usuarioRepository.findById(id).orElse(null)));
		model.addAttribute(usuarioRepository.findById(id).orElse(null));
		model.addAttribute("lstPerfiles",perfilService.getAll());
		return "usuario/modificarUsuario";
	}

	@GetMapping(value = "/eliminarUsuario/{id}")
	public String eliminar(@PathVariable int id) {
		usuarioService.remove(id);
		return "redirect:/usuarios/";
	}
	
	@GetMapping(value = "/usuariosPdf/")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Usuario> listUsers = usuarioService.getAll();
        System.out.println(listUsers);
         
        UsuariosPDFExporter exporter = new UsuariosPDFExporter(listUsers);
        exporter.export(response);
    }
	
	@PostMapping("/")
	public RedirectView create (@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		usuarioService.insertOrUpdate(usuarioModel);
		return new RedirectView("/usuarios/");
	}
	@PostMapping(value = "/editarUsuario/")
	public String update (@ModelAttribute Usuario usuario) {
		usuarioRepository.saveAndFlush(usuario);
		return "redirect:/usuarios/";
	}
	
}