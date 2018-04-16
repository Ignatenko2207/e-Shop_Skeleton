package org.itstep.service;

import java.util.List;

import org.itstep.model.Cart;
import org.itstep.model.Order;

public interface OrderService {

	Order save(Order order);

	Order update(Order order);

	Order get(Integer idOrder);

	void delete(Integer idOrder);

	List<Order> findAllByOrder();
}
