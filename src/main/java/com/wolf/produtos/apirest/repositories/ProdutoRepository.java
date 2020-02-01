package com.wolf.produtos.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolf.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
