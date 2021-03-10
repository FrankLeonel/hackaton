package br.ufc.hackathon.hackathon.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.hackathon.hackathon.model.Comerciante;
import br.ufc.hackathon.hackathon.repository.ComercianteRepository;
 
@Service
public class ComercianteService {
 
    @Autowired
    ComercianteRepository comerRepo;
    
    public Comerciante addUser(String login, String senha, String nome, String endereco, String itens, String email) {
        Comerciante comerciante = new Comerciante(login, senha, nome, endereco, itens, email);
        return comerRepo.save(comerciante);
    }
    
    public boolean removeUser(Integer id) {
        if(comerRepo.existsById(id)) {
            comerRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Comerciante> getUsers() {
        return comerRepo.findAll();
    }
    
    public Comerciante getComerciante(Integer id) {
        return comerRepo.findById(id).get();
    }
    
    public Comerciante getUserByLogin(String login) {
        return comerRepo.findFirstByLogin(login);
    }
    
    public Comerciante updateUser(Integer id, String login, String senha, String nome, String endereco, String itens, String email) {
        Comerciante comerAux = comerRepo.findById(id).get();
        
        if(comerAux != null) {
            comerAux.setLogin(login);;
            comerAux.setSenha(senha);
            comerRepo.save(comerAux);         
        }
        
        return comerAux;
    }
}

