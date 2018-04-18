package org.itstep.service;

import org.itstep.model.GoodOrder;

public interface OrderService {

	GoodOrder save(GoodOrder order);

	GoodOrder update(GoodOrder order);

	GoodOrder get(Integer idOrder);

	void delete(GoodOrder order);

}
