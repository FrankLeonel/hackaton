package br.ufc.hackathon.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.hackathon.hackathon.model.Produto;
import br.ufc.hackathon.hackathon.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRespository;

    public Produto addProduto(String nome, Integer quantidade, Double preco) {
        Produto produto = new Produto(nome, quantidade, preco);
        return produtoRespository.save(produto);
    }

    public boolean removeProduto(Integer id) {
        if (produtoRespository.existsById(id)) {
            produtoRespository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Produto> getProdutos() {
        return produtoRespository.findAll();
    }

    public Produto getProduto(Integer id) {
        return produtoRespository.findById(id).get();
    }

    public Produto getProdutoByLogin(String nome) {
        return produtoRespository.findFirstByNome(nome);
    }

    public Produto updateProduto(Integer id, String nome, Integer quantidade, Double preco) {
        Produto proAux = produtoRespository.findById(id).get();

        return proAux;
    }
}
