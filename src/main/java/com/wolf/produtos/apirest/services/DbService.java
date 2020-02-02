package com.wolf.produtos.apirest.services;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolf.produtos.apirest.models.Produto;
import com.wolf.produtos.apirest.repositories.ProdutoRepository;

@Service
public class DbService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public void instantiateTestDatabase() {
		Produto p1 = new Produto(null, "Notebook", new BigDecimal(5), new BigDecimal(5000));
		Produto p2 = new Produto(2L, "Computador", new BigDecimal(15), new BigDecimal(2000));
		Produto p3 = new Produto(3L, "Mouse", new BigDecimal(59), new BigDecimal(500));
		Produto p4 = new Produto(4L, "Teclado", new BigDecimal(52), new BigDecimal(200));
		Produto p5 = new Produto(5L, "Fone de Ouvido", new BigDecimal(21), new BigDecimal(100));
		Produto p6 = new Produto(6L, "Pen Driver", new BigDecimal(51), new BigDecimal(1080));
		Produto p7 = new Produto(7L, "Disquete", new BigDecimal(21), new BigDecimal(100));
		Produto p8 = new Produto(8L, "Smartphone", new BigDecimal(52), new BigDecimal(1070));
		Produto p9 = new Produto(9L, "Tablet", new BigDecimal(51), new BigDecimal(1040));
		Produto p10 = new Produto(10L, "Arduino", new BigDecimal(21), new BigDecimal(1020));
		Produto p11 = new Produto(11L, "Playstation", new BigDecimal(51), new BigDecimal(1200));

		produtoRepository.saveAll(Arrays.asList(p1, p2, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

	}
}
