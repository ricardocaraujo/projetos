package br.com.petrobras.exp.projetostg.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.petrobras.exp.projetostg.domain.Marco;
import br.com.petrobras.exp.projetostg.domain.Projeto;
import br.com.petrobras.exp.projetostg.domain.enums.LinhaPesquisa;
import br.com.petrobras.exp.projetostg.dto.ProjetoDTO;
import br.com.petrobras.exp.projetostg.services.ProjetoService;

@Controller
//@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	//no thymeleaf não é preciso colocar @ModelAttribute, com JSP ou JSTL trabalha com @ModelAttribute
	@RequestMapping(value="insere", method=RequestMethod.POST)
	public String salvaProjeto(@ModelAttribute Projeto projeto, Model model) {
		Projeto obj = projetoService.save(projeto);
		/*
		 * URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
		 * buildAndExpand(obj.getId()).toUri(); return
		 * ResponseEntity.created(uri).build();
		 */
		return "redirect:listaprojetos"; 
		//não se utiliza o obj Model no redirect porque senão a informação passada é perdida, neste caso utiliza-se o 
		//RedirectAttribute com o métido addFlashAttribute
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String preparaProjeto(Model model) {
		Projeto projeto = new Projeto();
		//List<Marco> marcos = new ArrayList<>();
		//marcos.add(new Marco());
		projeto.setMarco(new Marco());
		model.addAttribute("projeto", projeto);
		model.addAttribute("linhasDePesquisa", LinhaPesquisa.values());
		return "adicionaprojeto";
	}
	
	//ou pode usar o @GetMapping
	//@RequestParam usa-se quando os parâmetros vêm na URL
	@RequestMapping(value="/projeto/{id}", method=RequestMethod.GET) //ou pode usar path no lugar de value
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
		lista.forEach((p) -> System.out.println(p.getTitulo()));
		return "listaprojetos";
	}
//		Projeto projeto = projetoService.findById(id);
//		model.addAttribute("projeto", projeto);
//		return "exibeProjeto";
//	}
	
}
