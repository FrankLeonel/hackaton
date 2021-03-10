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

import br.ufc.hackathon.hackathon.model.Produto;
import br.ufc.hackathon.hackathon.service.ProdutoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> getProdutos() {
        return new ResponseEntity<List<Produto>>(produtoService.getProdutos(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable("id") Integer id) {

        Produto produto = produtoService.getProduto(id);

        if (produto != null) {
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> addProduto(@RequestBody Produto newProduto) {

        if (newProduto.getNome() == null || newProduto.getQuantidade() < 0 || newProduto.getPreco() < 0.0
                || newProduto.getNome().equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Produto>(
                produtoService.addProduto(newProduto.getNome(), newProduto.getQuantidade(), newProduto.getPreco()),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Produto> updateAgricultor(@PathVariable("id") Integer id, @RequestBody Produto produto) {

        if (produto.getNome() == null || produto.getQuantidade() < 0 || produto.getPreco() < 0.0
                || produto.getNome().equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(produto.toString());
        return new ResponseEntity<Produto>(produtoService.updateProduto(produto.getId(), produto.getNome(),
                produto.getQuantidade(), produto.getPreco()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteAgricultor(@PathVariable("id") Integer id) {
        if (produtoService.removeProduto(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
