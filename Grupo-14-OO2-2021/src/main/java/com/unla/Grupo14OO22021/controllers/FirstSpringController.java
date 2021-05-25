package com.unla.Grupo14OO22021.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("firstspring")
public class FirstSpringController {

	@GetMapping("helloworld")
	public String helloworld() {
		return "hola/helloworld";
	}
	
	@GetMapping("holamundo")
	public String holamundo() {
		return "hola/holamundo";
	}
}