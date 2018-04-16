package org.itstep.service;

import java.util.List;

import org.itstep.model.Account;
import org.itstep.model.Cart;

public interface CartService {

	Cart save(Cart cart);
	
	Cart update(Cart cart);
	
	Cart get(Integer id);
	
	void delete(Integer id);
	
	List<Cart> findAllByCart();
	
	List<Cart> findAllByCreationTime(Long startPeriod, Long endPeriod);
}
