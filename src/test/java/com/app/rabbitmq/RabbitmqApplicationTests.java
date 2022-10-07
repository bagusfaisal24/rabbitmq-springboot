package com.app.rabbitmq;

import com.app.rabbitmq.domain.DtoProduct;
import com.app.rabbitmq.publisher.ProductSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {

	@Autowired
	private ProductSender productSender;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSender() throws JsonProcessingException {
		DtoProduct dtoProduct = new DtoProduct();
		dtoProduct.setId("3");
		dtoProduct.setName("Komputer");
		dtoProduct.setQty(1);
		dtoProduct.setTypeMessage("insert");
		dtoProduct.setPrice(1000000f);
		String data = new ObjectMapper().writeValueAsString(dtoProduct);
		productSender.send(data);
	}
}
