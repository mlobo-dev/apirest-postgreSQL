package com.wolf.produtos.apirest.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wolf.produtos.apirest.models.Produto;
import com.wolf.produtos.apirest.services.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping("/produtos")
	public List<Produto> listarProdutos() {
		return service.findAll();
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
		service.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
