package br.com.senac.controller;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Acessorio;
import br.com.senac.service.AcessorioService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/acessorio")
public class AcessorioController {

	@Autowired
	AcessorioService service;
	
	@GetMapping("/listar")
	public ModelAndView listarAcessorios() {
		ModelAndView mv = new ModelAndView("acessorio/listaAcessorio");
		mv.addObject("acessorios", service.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAcessorio() {
		ModelAndView mv = new ModelAndView("Acessorio/cadastraAcessorio");
		mv.addObject("acessorio", new Acessorio());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAcessorio(Acessorio acessorio) {
		service.save(acessorio);
		return listarAcessorios();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAcessorio(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("Acessorio/alteraAcessorio");
		mv.addObject("acessorio", service.search(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterarAcessorio(Acessorio acessorio) throws ObjectNotFoundException{
		service.edit(acessorio);
		return listarAcessorios();
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarAcessorio(@PathVariable("id") Integer id) {
		service.delete(id);
		return listarAcessorios();
	}
	
}
