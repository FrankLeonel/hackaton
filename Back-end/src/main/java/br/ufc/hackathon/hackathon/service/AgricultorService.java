package br.ufc.hackathon.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.hackathon.hackathon.model.Agricultor;
import br.ufc.hackathon.hackathon.repository.AgricultorRepository;

@Service
public class AgricultorService {

    @Autowired
    AgricultorRepository agricultorRepository;

    public Agricultor addAgricultor(String login, String senha, String nome, String endereco, String itens,
            String email) {
        Agricultor agricultor = new Agricultor(login, senha, nome, endereco, itens, email);
        return agricultorRepository.save(agricultor);
    }

    public boolean removeAgricultor(Integer id) {
        if (agricultorRepository.existsById(id)) {
            agricultorRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Agricultor> getAgricultores() {
        return agricultorRepository.findAll();
    }

    public Agricultor getAgricultor(Integer id) {
        return agricultorRepository.findById(id).get();
    }

    public Agricultor getAgricultorByLogin(String login) {
        return agricultorRepository.findFirstByLogin(login);
    }

    public Agricultor updateAgricultor(Integer id, String login, String senha, String nome, String endereco,
            String itens, String email) {
        Agricultor agriAux = agricultorRepository.findById(id).get();

        if (agriAux != null) {
            agriAux.setLogin(login);
            ;
            agriAux.setSenha(senha);
            agricultorRepository.save(agriAux);
        }

        return agriAux;
    }
}
