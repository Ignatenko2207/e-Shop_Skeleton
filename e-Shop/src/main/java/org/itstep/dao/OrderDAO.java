package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.GoodOrder;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO{

	@Autowired
	HibernateUtil hiber;
	
	public GoodOrder save(GoodOrder order) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.saveOrUpdate(order);
		
		session.getTransaction().commit();
		session.close();
		
		if(getOne(order.getIdOrder()) != null) {
			return order;
		}
		
		return null;
	}

	public GoodOrder getOne(Integer id) {
		
		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		GoodOrder order = session.get(GoodOrder.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		return order;
	}

	public void delete(GoodOrder order) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.delete(order);
		
		session.getTransaction().commit();
		session.close();
	}
	
}
