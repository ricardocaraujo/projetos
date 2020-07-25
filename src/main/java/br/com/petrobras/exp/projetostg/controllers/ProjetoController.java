package br.com.petrobras.exp.projetostg.controllers;

import java.net.URI;

import javax.servlet.ServletRequestAttributeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.petrobras.exp.projetostg.domain.Projeto;
import br.com.petrobras.exp.projetostg.services.ProjetoService;

@Controller
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	//no thymeleaf não é preciso colocar @ModelAttribute
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvaProjeto(Projeto projeto) {
		Projeto obj = projetoService.save(projeto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String test() {
		return "adicionaprojeto";
	}
	
	@RequestMapping(value="/projeto/{id}", method=RequestMethod.GET)
	public ModelAndView buscaProjeto(@PathVariable("id") Integer id, ModelMap model) {
		Projeto projeto = projetoService.findById(id);
		model.addAttribute("projeto", projeto);
		return new ModelAndView("exibeProjeto", model);
		//return ResponseEntity.ok().body(projeto);
	}
	
	@RequestMapping(value="listaprojetos", method=RequestMethod.GET)
	public String listaProjetos(Model model) {
		Iterable<Projeto> lista = projetoService.findAll();
		model.addAttribute("projetos", lista);
		return "listaprojetos";
	}
	
	
		
//	@RequestMapping(value = "/projeto", method = RequestMethod.GET)
//	public String find(@RequestParam(name = "id") Integer id, Model model) {
//		Projeto projeto = projetoService.findById(id);
//		model.addAttribute("projeto", projeto);
//		return "exibeProjeto";
//	}
	
}
