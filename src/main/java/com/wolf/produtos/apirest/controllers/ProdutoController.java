package com.wolf.produtos.apirest.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.find(id));
	}

	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> listAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@PostMapping("/produtos")
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		service.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@DeleteMapping("/produtos")
	public ResponseEntity<Produto> delete(@RequestBody Produto produto) {
		service.delete(produto);
		return ResponseEntity.ok().body(produto);

	}

	@PutMapping("/produtos/{id}")
	public ResponseEntity<Void> update(@RequestBody Produto produto, @PathVariable Long id){
		produto.setId(id);
		produto = service.update(produto);
		return ResponseEntity.noContent().build();
		
	}
}
