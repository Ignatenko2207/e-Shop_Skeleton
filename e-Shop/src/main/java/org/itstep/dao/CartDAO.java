package org.itstep.dao;

import java.util.List;

import org.itstep.model.Account;
import org.itstep.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer>{

	List<Cart> findAllByCart();
	
	@Query(value="SELECT * FROM carts WHERE creation_time>?1 AND creation_time<?2", nativeQuery=true)
	List<Cart> findAllByCreationTime(Long startPeriod, Long endPeriod);
}
