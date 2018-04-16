package org.itstep.service.impl;


import java.util.List;

import org.itstep.dao.GoodDAO;
import org.itstep.model.Good;
import org.itstep.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {

	@Autowired
	GoodDAO goodDao;

	public Good save(Good good) {
		if(goodDao.getOne(good.getArticleId()) == null) {
			return goodDao.save(good);
		}
		
		return null;
	}

	public Good update(Good good) {
		if(goodDao.getOne(good.getArticleId()) != null) {
			return goodDao.save(good);
		}
		return null;
	}

	public Good get(String id) {
		return goodDao.getOne(id);
	}

	public void delete(String id) {
		Good good = goodDao.getOne(id);
		if(good != null) {
			goodDao.delete(good);
		}
	}

	public List<Good> findAllByAvailability() {
		return goodDao.findAllByAvailability();
	}
}
