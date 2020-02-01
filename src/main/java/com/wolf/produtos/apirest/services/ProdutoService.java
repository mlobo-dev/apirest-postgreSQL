package com.wolf.produtos.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wolf.produtos.apirest.models.Produto;
import com.wolf.produtos.apirest.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto save(Produto entity) {
		return repository.save(entity);
	}

	public Produto find(Long id) {
		Optional<Produto> entity = repository.findById(id);
		return entity.orElseThrow(
				() -> new RuntimeException("Objeto não encontrado:" + id + ", Tipo: " + Produto.class.getName()));
	}

	public void delete(Produto entity) {
		repository.delete(entity);
	}

	public Produto update(Produto entity) {
		find(entity.getId());
		return repository.save(entity);
	}

	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

}
