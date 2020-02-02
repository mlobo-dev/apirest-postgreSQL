package com.wolf.produtos.apirest;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.wolf.produtos.apirest.models.Produto;
import com.wolf.produtos.apirest.services.ProdutoService;

@SpringBootTest
public class ProdutoServiceTest {

	@Autowired
	private ProdutoService service;

	@Test
	@Rollback
	public void createShouldPersistData() {
		Produto p = new Produto(2L, "beterraba doce", new BigDecimal(2), new BigDecimal(56));

		service.save(p);
		Assertions.assertThat(p.getId()).isNotNull();
		Assertions.assertThat(p.getNome()).isEqualTo("beterraba doce");
		Assertions.assertThat(p.getQuantidade()).isEqualTo(new BigDecimal(2));
		Assertions.assertThat(p.getValor()).isEqualTo(new BigDecimal(56));
		
		Produto p2 = service.find(11L);
		service.delete(p2);
		
	}

}
