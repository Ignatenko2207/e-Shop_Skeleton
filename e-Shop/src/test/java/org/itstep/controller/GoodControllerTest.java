package org.itstep.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.ApplicationRunner;
import org.itstep.model.Good;
import org.itstep.service.GoodService;
import org.junit.After;
import org.junit.Before;
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
import org.springframework.web.bind.annotation.RequestHeader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GoodControllerTest {

	@MockBean
	GoodService goodService;

	@Autowired
	TestRestTemplate restTemplate;

	List<Good> goods = new ArrayList<Good>();

	@Before
	public void setUp() throws Exception {

		for (int i = 1; i <= 3; i++) {
			Good testGood = new Good();
			testGood.setArticleId("id" + i);
			testGood.setAvailability(Boolean.TRUE);
			testGood.setName("good" + i);
			testGood.setPrice(100 * i);
			testGood.setInitialPrice(100 * i);

			goods.add(testGood);

		}

	}

	@Test
	public void testSaveGood() throws URISyntaxException {

		Mockito.when(goodService.save(Mockito.any(Good.class))).thenReturn(goods.get(0));

		RequestEntity<Good> request = new RequestEntity<Good>(goods.get(0), HttpMethod.POST, new URI("/good"));

		ResponseEntity<Good> response = restTemplate.exchange(request, Good.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Mockito.verify(goodService, Mockito.times(1)).save(Mockito.any(Good.class));
	}

	@Test
	public void testUpdateGood() {
	}

	@Test
	public void testDeleteGood() throws URISyntaxException {

		Mockito.doNothing().when(goodService).delete(Mockito.any(Good.class));  

		RequestEntity<Good> request = new RequestEntity<Good>(goods.get(0), HttpMethod.DELETE, new URI("/good"));

		ResponseEntity<Good> response = restTemplate.exchange(request, Good.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Mockito.verify(goodService, Mockito.times(1)).delete(Mockito.any(Good.class));
	}

	@Test
	public void testGetGood() throws URISyntaxException {
		Mockito.when(goodService.get(Mockito.anyString())).thenReturn(goods.get(0));  

		HttpHeaders headers = new HttpHeaders();
		headers.add("login", "good1");
		
		RequestEntity request = new RequestEntity(headers, HttpMethod.GET, new URI("/good/get-one"));

		ResponseEntity<Good> response = restTemplate.exchange(request, Good.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Mockito.verify(goodService, Mockito.times(1)).get(Mockito.anyString());
		
	}

	@Test
	public void testFindAllByAvailability() throws URISyntaxException {
		Mockito.when(goodService.findAllByAvailability(Boolean.TRUE)).thenReturn(goods);  

		HttpHeaders headers = new HttpHeaders();
		headers.add("availability", "true");
		
		RequestEntity request = new RequestEntity(headers, HttpMethod.GET, new URI("/good/get-by-availability"));

		ResponseEntity<List> response = restTemplate.exchange(request, List.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Mockito.verify(goodService, Mockito.times(1)).findAllByAvailability(Boolean.TRUE);
	}

}
