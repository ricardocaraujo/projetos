package br.com.petrobras.exp.projetostg.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.petrobras.exp.projetostg.domain.Empregado;
import br.com.petrobras.exp.projetostg.services.EmpregadoService;

@Component
public class StringToEmpregadoConverter implements Converter<String, Empregado> {

	@Autowired
	private EmpregadoService empregadoService;
	
	@Override
	public Empregado convert(String s) {
		if(s.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(s);
		return empregadoService.getOne(id);
	}

}
