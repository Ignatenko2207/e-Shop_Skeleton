package org.itstep.service.impl;

import org.itstep.dao.OrderDAO;
import org.itstep.model.GoodOrder;
import org.itstep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;

	public GoodOrder save(GoodOrder order) {
		if (orderDAO.getOne(order.getIdOrder()) != null) {
			return orderDAO.save(order);
		}
		return null;
	}

	public GoodOrder update(GoodOrder order) {
		if (orderDAO.getOne(order.getIdOrder()) != null) {
			return orderDAO.save(order);
		}
		return null;
	}

	public GoodOrder get(Integer idOrder) {
		return orderDAO.getOne(idOrder);
	}

	public void delete(GoodOrder order) {
		orderDAO.delete(order);
	}

}
