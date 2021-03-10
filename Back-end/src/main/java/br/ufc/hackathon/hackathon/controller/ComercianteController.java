package br.ufc.hackathon.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.hackathon.hackathon.model.Comerciante;
import br.ufc.hackathon.hackathon.service.ComercianteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/comerciantes")
public class ComercianteController {

    @Autowired
    ComercianteService comercianteService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Comerciante>> getComerciantes() {
        return new ResponseEntity<List<Comerciante>>(comercianteService.getComerciantes(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Comerciante> getComerciante(@PathVariable("id") Integer id) {

        Comerciante comerciante = comercianteService.getComerciante(id);

        if (comerciante != null) {
            return new ResponseEntity<Comerciante>(comerciante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Comerciante> addComerciante(@RequestBody Comerciante newComerciante) {

        if (newComerciante.getLogin() == null || newComerciante.getNome() == null || newComerciante.getEmail() == null
                || newComerciante.getSenha() == null || newComerciante.getEndereco() == null
                || newComerciante.getNome().equals("null") || newComerciante.getEmail().equals("null")
                || newComerciante.getSenha().equals("null") || newComerciante.getEndereco().equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Comerciante>(comercianteService.addComerciante(newComerciante.getLogin(),
                newComerciante.getSenha(), newComerciante.getNome(), newComerciante.getEndereco(),
                newComerciante.getItens(), newComerciante.getEmail()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Comerciante> updateComerciante(@PathVariable("id") Integer id,
            @RequestBody Comerciante comerciante) {

        if (comerciante.getLogin() == null || comerciante.getNome() == null || comerciante.getEmail() == null
                || comerciante.getSenha() == null || comerciante.getEndereco() == null
                || comerciante.getNome().equals("null") || comerciante.getEmail().equals("null")
                || comerciante.getSenha().equals("null") || comerciante.getEndereco().equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Comerciante>(comercianteService.updateComerciante(comerciante.getId(),
                comerciante.getLogin(), comerciante.getSenha(), comerciante.getNome(), comerciante.getEndereco(),
                comerciante.getItens(), comerciante.getEmail()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteComerciante(@PathVariable("id") Integer id) {
        if (comercianteService.removeComerciante(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
