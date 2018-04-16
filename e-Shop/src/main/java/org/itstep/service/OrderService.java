package org.itstep.service;

import org.itstep.model.Order;

public interface OrderService {

	Order save(Order order);

	Order update(Order order);

	Order get(Integer idOrder);

	void delete(Order order);

}
