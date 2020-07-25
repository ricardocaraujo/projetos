package br.com.petrobras.exp.projetostg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petrobras.exp.projetostg.domain.Marco;

@Repository
public interface MarcoRepository extends JpaRepository<Marco, Integer> {

}
