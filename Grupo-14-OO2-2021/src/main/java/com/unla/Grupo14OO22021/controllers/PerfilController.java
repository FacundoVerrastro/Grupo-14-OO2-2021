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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lowagie.text.DocumentException;
import com.unla.Grupo14OO22021.Exporters.PerfilesPDFExporter;
import com.unla.Grupo14OO22021.entities.Perfil;
import com.unla.Grupo14OO22021.models.PerfilModel;
import com.unla.Grupo14OO22021.repositories.IPerfilRepository;
import com.unla.Grupo14OO22021.services.IPerfilService;

@Controller
@RequestMapping("/perfiles")
public class PerfilController {

	@Autowired
	@Qualifier("perfilService")
	private IPerfilService perfilService;
	
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView("perfil/index");
		mAV.addObject("perfiles", perfilService.getAll());
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}
	@GetMapping(value="/editar/{id}")
	public String modificarUsuario(@PathVariable int id,Model model) {
		model.addAttribute("perfil",perfilRepository.findById(id).orElse(null));
		return "perfil/modificarPerfil";
	}
	
	@GetMapping(value = "/eliminarPerfil/{id}")
	public String eliminar(@PathVariable int id) {
		perfilService.remove(id);
		return "redirect:/perfiles/";
	}
	@GetMapping(value = "/perfilesPdf/")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Perfil> lstPerfil = perfilService.getAll();
         
        PerfilesPDFExporter exporter = new PerfilesPDFExporter(lstPerfil);
        exporter.export(response);
    }
	
	@PostMapping("/")
	public RedirectView create (@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView("");
	}
	@PostMapping(value = "/editarPerfil/")
	public String update (@ModelAttribute Perfil perfil) {
		perfilRepository.saveAndFlush(perfil);
		return "redirect:/perfiles/";
	}
}
