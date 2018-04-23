package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.List;

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
public class GoodDAOTest {

	Good goodInDB;
	
	@Autowired
	GoodDAO goodDAO;
	
	
	@Before
	public void setPreData() {
		Good good = new Good();
				
		good.setArticleId("123_my_good");
		good.setAvailability(Boolean.TRUE);
		good.setDescription("my description");
		good.setInitialPrice(2000);
		good.setPrice(1500);
		good.setName("My favorite good");
		good.setUnits("pts");
		goodInDB = goodDAO.save(good);
			
	}
	
	
	@Test
	public void testFindAllByAvailability() {
		List<Good> goods = goodDAO.findAllByAvailability(Boolean.TRUE);
		
		List<Good> unavailableGoods = goodDAO.findAllByAvailability(Boolean.FALSE);
		
		assertNotNull(goods);
		assertNotNull(unavailableGoods);
		
		assertEquals(1, goods.size());
		assertTrue(unavailableGoods.isEmpty());
		
		assertEquals("123_my_good", goods.get(0).getArticleId());
		
	}

	@After
	public void cleanDB() {
		goodDAO.delete(goodInDB);
	}
}
