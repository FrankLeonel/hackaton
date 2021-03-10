package br.ufc.hackathon.hackathon.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.hackathon.hackathon.model.Produto;
import br.ufc.hackathon.hackathon.repository.ProdutoRepository;
 
@Service
public class ProdutoService {
 
    @Autowired
    ProdutoRepository proRepo;
    
    public Produto addUser(String nome, Integer quantidade, Double preco) {
        Produto produto = new Produto(nome, quantidade, preco);
        return proRepo.save(produto);
    }
    
    public boolean removeUser(Integer id) {
        if(proRepo.existsById(id)) {
            proRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Produto> getUsers() {
        return proRepo.findAll();
    }
    
    public Produto getProduto(Integer id) {
        return proRepo.findById(id).get();
    }
    
    public Produto getUserByLogin(String nome) {
        return proRepo.findFirstByNome(nome);
    }
    
    public Produto updateUser(Integer id, String nome, Integer quantidade, Double preco) {
        Produto proAux = proRepo.findById(id).get();
       
        return proAux;
    }
}

