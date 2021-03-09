package br.ufc.hackathon.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufc.hackathon.hackathon.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

}
