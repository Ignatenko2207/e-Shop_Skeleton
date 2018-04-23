package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.itstep.ApplicationRunner;
import org.itstep.model.Account;
import org.itstep.model.Cart;
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
public class CartDAOTest {

	Cart cartInDB;

	Account accountInDB;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	AccountDAO accountDAO;

	@Before
	public void setPreData() {
		Account account = new Account();
		Cart cart = new Cart();

		account.setLogin("Ignatenko2207");
		account.setPassword("12345678");
		account.setFirstName("Alex");
		account.setSecondName("Ignatenko");
		account.setTelephone("+380967933438");
		accountInDB = accountDAO.save(account);

		cart.setCreationTime(System.currentTimeMillis());
		cart.setAccount(account);
		cartInDB = cartDAO.save(cart);

	}

	@Test
	public void testFindAllByCreationTime() {

		List<Cart> carts = cartDAO.findAllByCreationTime((System.currentTimeMillis()-10000), (System.currentTimeMillis()+10000), "Ignatenko2207");
		 assertNotNull(carts);
		 assertEquals(1, carts.size());
		 
		 assertEquals("+380967933438", carts.get(0).getAccount().getTelephone());
	
	}

	@After
	public void deleteTestData() {
		cartDAO.delete(cartInDB);
		accountDAO.delete(accountInDB);
	}
}
