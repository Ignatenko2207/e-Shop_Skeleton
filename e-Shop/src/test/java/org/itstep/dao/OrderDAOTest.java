package org.itstep.dao;

import static org.junit.Assert.*;

import org.itstep.ApplicationRunner;
import org.itstep.model.Account;
import org.itstep.model.Cart;
import org.itstep.model.Good;
import org.itstep.model.GoodOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class OrderDAOTest {

	GoodOrder orderInDB;
		
	Cart cartInDB;
	
	Good goodInDB;
	
	Account accountInDB;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	GoodDAO goodDAO;
	
	@Autowired
	AccountDAO accountDAO;
	
	@Before
	public void setPreData() {
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
		goodInDB = goodDAO.save(good);
		
		account.setLogin("Ignatenko2207");
		account.setPassword("12345678");
		account.setFirstName("Alex");
		account.setSecondName("Ignatenko");
		account.setTelephone("+380967933438");
		accountInDB = accountDAO.save(account);
		
		cart.setId(123);
		cart.setCreationTime(System.currentTimeMillis());
		cart.setAccount(account);
		cartInDB = cartDAO.save(cart);
		
		order.setIdOrder(12345);
		order.setGood(good);
		order.setAmount(2);
		order.setCart(cart);
		orderInDB = orderDAO.save(order);
		
	}
	
	@Test
	public void testGetOne() {
		assertNotNull(orderInDB);
		
		GoodOrder testOrder = orderDAO.getOne(orderInDB.getIdOrder());
		
		assertEquals(testOrder.getAmount(), Integer.valueOf(2));
	}

//	@After
//	public void deleteTestData() {
//		orderDAO.delete(orderInDB);
//		cartDAO.delete(cartInDB);
//		goodDAO.delete(goodInDB);
//		accountDAO.delete(accountInDB);
//	}

}
