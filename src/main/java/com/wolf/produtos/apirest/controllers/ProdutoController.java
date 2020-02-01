package com.wolf.produtos.apirest.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wolf.produtos.apirest.models.Produto;
import com.wolf.produtos.apirest.services.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/produtos")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping("/{id}")
	@ApiOperation("Retorna um Produto do banco de dados através do ID")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.find(id));
	}

	@GetMapping
	@ApiOperation("Retorna uma lista com todos os Produtos do banco de dados.")
	public ResponseEntity<List<Produto>> listAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@PostMapping
	@ApiOperation("Salva um novo Produto no banco de dados")
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		service.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@DeleteMapping
	@ApiOperation("Remove um Produto do banco de dados")
	public ResponseEntity<Produto> delete(@RequestBody Produto produto) {
		service.delete(produto);
		return ResponseEntity.ok().body(produto);

	}

	@PutMapping("/{id}")
	@ApiOperation("Atualiza informações de um Produto")
	public ResponseEntity<Void> update(@RequestBody Produto produto, @PathVariable Long id) {
		produto.setId(id);
		produto = service.update(produto);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ApiOperation("Traz os produtos de forma páginada de acordo com a quantidade desejada.")
	public ResponseEntity<Page<Produto>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
		@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
		@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
		@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Produto> list = service.findPage(page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(list);
	}
}
