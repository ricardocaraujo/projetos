package br.com.petrobras.exp.projetostg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petrobras.exp.projetostg.domain.Projeto;
import br.com.petrobras.exp.projetostg.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;
	
	public Projeto save(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	public List<Projeto> findAll() {
		return projetoRepository.findAll();
	}
	
	public Projeto findById(Integer id) {
		return (Projeto) projetoRepository.getOne(id);
	}
}
