package org.itstep.dao;

import java.util.List;

import org.itstep.model.Account;
import org.itstep.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListDAO extends JpaRepository<WishList, Integer>{

	List<WishList> findAllByWishList();
}
