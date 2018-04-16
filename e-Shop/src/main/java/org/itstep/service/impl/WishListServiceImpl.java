package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.WishListDAO;
import org.itstep.model.WishList;
import org.itstep.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListServiceImpl implements WishListService {

	@Autowired
	private WishListDAO wishListDAO;

	@Override
	public WishList save(WishList wishList) {
		if (wishListDAO.getOne(wishList.getId()) != null) {
			return wishListDAO.save(wishList);
		}
		return null;
	}

	@Override
	public WishList update(WishList wishList) {
		if (wishListDAO.getOne(wishList.getId()) != null) {
			return wishListDAO.save(wishList);
		}
		return null;
	}

	@Override
	public WishList get(Integer id) {

		return wishListDAO.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		WishList wishList = wishListDAO.getOne(id);
		if(wishList != null) {
			wishListDAO.delete(id);
		}

	}

	@Override
	public List<WishList> findAllByWishList() {

		return wishListDAO.findAllByWishList();
	}

}
