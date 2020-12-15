package br.com.petrobras.exp.projetostg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petrobras.exp.projetostg.domain.Empregado;
import br.com.petrobras.exp.projetostg.repositories.EmpregadoRepository;

@Service
public class EmpregadoService {
	
	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	public void save(Empregado obj) {
		this.empregadoRepository.save(obj);
	}
	
	public List<Empregado> findAll(){
		return this.empregadoRepository.findAll();
	}
	
	public Empregado getOne(Integer id) {
		return (Empregado) this.empregadoRepository.getOne(id);
	}

}
