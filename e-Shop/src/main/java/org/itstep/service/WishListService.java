package org.itstep.service;

import org.itstep.model.WishList;

public interface WishListService {

	WishList save(WishList wishList);

	WishList update(WishList wishList);

	WishList get(Integer id);

	void delete(WishList wishList);

}
