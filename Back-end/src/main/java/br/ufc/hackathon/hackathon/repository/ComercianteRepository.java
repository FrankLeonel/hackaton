package br.ufc.hackathon.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.hackathon.hackathon.model.Comerciante;

public interface ComercianteRepository extends JpaRepository <Comerciante, Integer>{
	Comerciante findFirstByLogin(String login);
}
