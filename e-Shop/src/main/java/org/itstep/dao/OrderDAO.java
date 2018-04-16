package org.itstep.dao;

import java.util.List;

import org.itstep.model.Cart;
import org.itstep.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

	
	List<Order> findAllByOrder();
	
}
