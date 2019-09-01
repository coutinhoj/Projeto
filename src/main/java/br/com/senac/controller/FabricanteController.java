package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Fabricante;
import br.com.senac.service.FabricanteService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {
	
	@Autowired
	FabricanteService service;
	
	@GetMapping("/listar")
	public ModelAndView listarFabricantes() {
		ModelAndView mv = new ModelAndView("fabricante/listaFabricante");
		mv.addObject("fabricantes", service.serchAll());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarFabricante(Fabricante fabricante) {
		service.save(fabricante);
		return listarFabricantes();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarFabricante(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("fabricante/alteraFabricante");
		mv.addObject("fabricante", service.search(id));
		return mv;
	}
	
	@GetMapping("/alterar")
	public ModelAndView alterarFabricante(Fabricante fabricante) throws ObjectNotFoundException{
		service.edit(fabricante);
		return listarFabricantes();
	}
	
	
	public ModelAndView deletarFabriacnte(@PathVariable("id") Integer id) {
		service.delete(id);
		return listarFabricantes();
	}

}
