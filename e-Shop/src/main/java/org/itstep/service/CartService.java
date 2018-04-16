package org.itstep.service;

import java.util.List;

import org.itstep.model.Cart;

public interface CartService {

	Cart save(Cart cart);
	
	Cart update(Cart cart);
	
	Cart get(Integer id);
	
	void delete(Cart cart);
	
	List<Cart> findAllByCreationTime(Long startPeriod, Long endPeriod, String login);
}
