package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.Chave;

public interface ChaveRepository extends JpaRepository<Chave, Integer>{

}
