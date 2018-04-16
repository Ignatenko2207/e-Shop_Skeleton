package org.itstep.service.impl;

import org.itstep.dao.WishListDAO;
import org.itstep.model.WishList;
import org.itstep.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListServiceImpl implements WishListService {

	@Autowired
	private WishListDAO wishListDAO;

	public WishList save(WishList wishList) {
		if (wishListDAO.getOne(wishList.getId()) != null) {
			return wishListDAO.save(wishList);
		}
		return null;
	}

	public WishList update(WishList wishList) {
		if (wishListDAO.getOne(wishList.getId()) != null) {
			return wishListDAO.save(wishList);
		}
		return null;
	}

	public WishList get(Integer id) {

		return wishListDAO.getOne(id);
	}

	public void delete(WishList wishList) {
			wishListDAO.delete(wishList);
	}
}
