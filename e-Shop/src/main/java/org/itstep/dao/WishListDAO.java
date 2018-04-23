package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.WishList;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WishListDAO{

	@Autowired
	HibernateUtil hiber;
	

	// ADD List<WishList> getByAccount
	
	public WishList save(WishList wishList) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.saveOrUpdate(wishList);
		
		session.getTransaction().commit();
		session.close();
		
		if(getOne(wishList.getId()) != null) {
			return wishList;
		}
		
		return null;
	}

	public WishList getOne(Integer id) {
		
		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		WishList wishList = session.get(WishList.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		return wishList;
	}

	public void delete(WishList wishList) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.delete(wishList);
		
		session.getTransaction().commit();
		session.close();
	}
	
}
