package com.example.Spring_Boot.controller;

import com.example.Spring_Boot.exceptions.RecursoNaoEncontradoException;
import com.example.Spring_Boot.model.Produto;
import com.example.Spring_Boot.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> produtoList(){
        return produtoService.produtoList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id){
        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
         produtoService.deletarPorId(id);
         return ResponseEntity.noContent().build();
    }
}
