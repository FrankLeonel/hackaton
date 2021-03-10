package br.ufc.hackathon.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.hackathon.hackathon.model.Agricultor;
import br.ufc.hackathon.hackathon.service.AgricultorService;

@CrossOrigin(origins = "localhost:8080")
@RestController
@RequestMapping(path = "/api/agricultores")
public class AgricultorController {

    @Autowired
    AgricultorService agricultorService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Agricultor>> getAgricultores() {
        return new ResponseEntity<List<Agricultor>>(agricultorService.getAgricultores(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Agricultor> getAgricultor(@PathVariable("id") Integer id) {

        Agricultor agricultor = agricultorService.getAgricultor(id);

        if (agricultor != null) {
            return new ResponseEntity<Agricultor>(agricultor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Agricultor> addAgricultor(@RequestBody Agricultor newAgricultor) {

        if (newAgricultor.getLogin() == null ||
                newAgricultor.getNome() == null ||
                newAgricultor.getEmail() == null ||
                newAgricultor.getSenha() == null ||
                newAgricultor.getEndereco() == null ||
                newAgricultor.getItens() == null ||
                newAgricultor.getNome().equals("null") ||
                newAgricultor.getEmail().equals("null") ||
                newAgricultor.getSenha().equals("null") ||
                newAgricultor.getEndereco().equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Agricultor>(agricultorService.addAgricultor(newAgricultor.getLogin(),
                newAgricultor.getSenha(), newAgricultor.getNome(), newAgricultor.getEndereco(), newAgricultor.getItens(), newAgricultor.getEmail()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Agricultor> updateAgricultor(@PathVariable("id") Integer id, @RequestBody Agricultor agricultor) {

        if (agricultor.getLogin() == null ||
                agricultor.getNome() == null ||
                agricultor.getEmail() == null ||
                agricultor.getSenha() == null ||
                agricultor.getEndereco() == null ||
                agricultor.getItens() == null ||
                agricultor.getNome().equals("null") ||
                agricultor.getEmail().equals("null") ||
                agricultor.getSenha().equals("null") ||
                agricultor.getEndereco().equals("null")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Agricultor>(agricultorService.updateAgricultor(agricultor.getId(), agricultor.getLogin(),
                agricultor.getSenha(), agricultor.getNome(), agricultor.getEndereco(), agricultor.getItens(), agricultor.getEmail()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteAgricultor(@PathVariable("id") Integer id) {
        if (agricultorService.removeAgricultor(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
