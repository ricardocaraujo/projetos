package br.com.petrobras.exp.projetostg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petrobras.exp.projetostg.domain.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

}
