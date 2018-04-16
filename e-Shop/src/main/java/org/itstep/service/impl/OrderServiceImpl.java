package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.OrderDAO;
import org.itstep.model.Cart;
import org.itstep.model.Order;
import org.itstep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;

	public Order save(Order order) {
		if (orderDAO.getOne(order.getIdOrder()) != null) {
			return orderDAO.save(order);
		}
		return null;
	}

	public Order update(Order order) {
		if (orderDAO.getOne(order.getIdOrder()) != null) {
			return orderDAO.save(order);

		}
		return null;
	}

	public Order get(Integer idOrder) {
		
		return orderDAO.getOne(idOrder);
	}

	public void delete(Integer idOrder) {
		Order order = orderDAO.getOne(idOrder);
		if(order != null) {
			orderDAO.delete(idOrder);
		}

	}

	public List<Order> findAllByOrder() {
		
		return orderDAO.findAllByOrder();
	}

}
