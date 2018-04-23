package org.itstep.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.itstep.ApplicationRunner;
import org.itstep.model.Account;
import org.itstep.model.Cart;
import org.itstep.model.Good;
import org.itstep.model.GoodOrder;
import org.itstep.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@MockBean
	OrderService orderServise;
	
	@Test
	public void testGetOrder() throws URISyntaxException {
		
		Good good = new Good();
		Account account = new Account();
		Cart cart = new Cart();
		GoodOrder order = new GoodOrder();
		
		good.setArticleId("123_my_good");
		good.setAvailability(Boolean.TRUE);
		good.setDescription("my description");
		good.setInitialPrice(2000);
		good.setPrice(1500);
		good.setName("My favorite good");
		good.setUnits("pts");
		
		account.setLogin("Ignatenko2207");
		account.setPassword("12345678");
		account.setFirstName("Alex");
		account.setSecondName("Ignatenko");
		account.setTelephone("+380967933438");
		
		cart.setCreationTime(System.currentTimeMillis());
		cart.setAccount(account);
		
		order.setGood(good);
		order.setAmount(2);
		order.setCart(cart);
		
		Mockito.when(orderServise.get(Mockito.anyInt())).thenReturn(order);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("id", "12345");
		
		RequestEntity<Integer> request = new RequestEntity<Integer>(headers, HttpMethod.GET, new URI("/order"));
		
		ResponseEntity<GoodOrder> response = testRestTemplate.exchange(request, GoodOrder.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
