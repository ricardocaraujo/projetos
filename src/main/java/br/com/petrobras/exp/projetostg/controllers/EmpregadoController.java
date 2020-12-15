package br.com.petrobras.exp.projetostg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.petrobras.exp.projetostg.domain.Empregado;
import br.com.petrobras.exp.projetostg.services.EmpregadoService;

@Controller
public class EmpregadoController {

	@Autowired
	private EmpregadoService empregadoService;
	
	public String insere(Empregado empregado) {
		empregadoService.save(empregado); 
	}
	
	
	
}
