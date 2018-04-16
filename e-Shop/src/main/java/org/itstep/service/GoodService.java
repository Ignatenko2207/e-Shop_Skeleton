package org.itstep.service;

import java.util.List;

import org.itstep.model.Good;

public interface GoodService {
	
	Good save(Good good);
	
	Good update(Good good);
	
	Good get(String id);
	
	void delete (String id);

	List<Good> findAllByAvailability ();
}
