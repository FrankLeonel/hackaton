package br.ufc.hackathon.hackathon.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.hackathon.hackathon.model.Agricultor;
import br.ufc.hackathon.hackathon.repository.AgricultorRepository;
 
@Service
public class AgricultorService {
 
    @Autowired
    AgricultorRepository agriRepo;
    
    public Agricultor addUser(String login, String senha, String nome, String endereco, String itens, String email) {
        Agricultor agricultor = new Agricultor(login, senha, nome, endereco, itens, email);
        return agriRepo.save(agricultor);
    }
    
    public boolean removeUser(Integer id) {
        if(agriRepo.existsById(id)) {
            agriRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Agricultor> getUsers() {
        return agriRepo.findAll();
    }
    
    public Agricultor getAgricultor(Integer id) {
        return agriRepo.findById(id).get();
    }
    
    public Agricultor getUserByLogin(String login) {
        return agriRepo.findFirstByLogin(login);
    }
    
    public Agricultor updateUser(Integer id, String login, String senha, String nome, String endereco, String itens, String email) {
        Agricultor agriAux = agriRepo.findById(id).get();
        
        if(agriAux != null) {
            agriAux.setLogin(login);;
            agriAux.setSenha(senha);
            agriRepo.save(agriAux);         
        }
        
        return agriAux;
    }
}
