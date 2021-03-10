package br.ufc.hackathon.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.hackathon.hackathon.model.Comerciante;
import br.ufc.hackathon.hackathon.repository.ComercianteRepository;

@Service
public class ComercianteService {

    @Autowired
    ComercianteRepository comercianteRepository;

    public Comerciante addComerciante(String login, String senha, String nome, String endereco, String itens,
            String email) {
        Comerciante comerciante = new Comerciante(login, senha, nome, endereco, itens, email);
        return comercianteRepository.save(comerciante);
    }

    public boolean removeComerciante(Integer id) {
        if (comercianteRepository.existsById(id)) {
            comercianteRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Comerciante> getComerciantes() {
        return comercianteRepository.findAll();
    }

    public Comerciante getComerciante(Integer id) {
        return comercianteRepository.findById(id).get();
    }

    public Comerciante getComercianteByLogin(String login) {
        return comercianteRepository.findFirstByLogin(login);
    }

    public Comerciante updateComerciante(Integer id, String login, String senha, String nome, String endereco,
            String itens, String email) {
        Comerciante comerciante = comercianteRepository.findById(id).get();

        if (comerciante != null) {
            comerciante.setLogin(login);
            comerciante.setSenha(senha);
            comerciante.setNome(nome);
            comerciante.setEndereco(endereco);
            comerciante.setEmail(email);

            comercianteRepository.save(comerciante);
        }

        return comerciante;
    }
}
