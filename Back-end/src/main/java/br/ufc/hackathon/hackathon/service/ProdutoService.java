package br.ufc.hackathon.hackathon.service;

import java.util.List;

import org.hibernate.hql.internal.ast.tree.QueryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.hackathon.hackathon.model.Produto;
import br.ufc.hackathon.hackathon.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto addProduto(String nome, Integer quantidade, Double preco) {
        Produto produto = new Produto(nome, quantidade, preco);
        return produtoRepository.save(produto);
    }

    public boolean removeProduto(Integer id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProduto(Integer id) {
        return produtoRepository.findById(id).get();
    }

    public Produto getProdutoByLogin(String nome) {
        return produtoRepository.findFirstByNome(nome);
    }

    public Produto updateProduto(Integer id, String nome, Integer quantidade, Double preco) {
        Produto produto = produtoRepository.findById(id).get();
        if (produto != null) {
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);

            produtoRepository.save(produto);
        }
        System.out.println(produto.toString());
        return produto;
    }
}
