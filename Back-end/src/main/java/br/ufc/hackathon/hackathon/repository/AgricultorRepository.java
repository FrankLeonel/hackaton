package br.ufc.hackathon.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufc.hackathon.hackathon.model.Agricultor;

public interface AgricultorRepository extends JpaRepository <Agricultor, Integer>{

}
