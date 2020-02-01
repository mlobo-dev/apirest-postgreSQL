package com.wolf.produtos.apirest.services;

import java.util.List;

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
}
