package com.wolf.produtos.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		return entity.orElseThrow(() -> new RuntimeException("Objeto não encontrado:" + id + ", Tipo: " + Produto.class.getName()));
	}

	public void delete(Produto entity) {
		repository.delete(entity);
	}
	
	public Produto update(Produto entity) {
		find(entity.getId());
		return repository.save(entity);
	}

}
