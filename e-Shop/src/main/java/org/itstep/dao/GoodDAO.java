package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.itstep.model.Good;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodDAO{
	
	@Autowired
	HibernateUtil hiber;
	
	public Good save(Good good) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.saveOrUpdate(good);
		
		session.getTransaction().commit();
		session.close();
		
		if(getOne(good.getArticleId()) != null) {
			return good;
		}
		
		return null;
	}

	public Good getOne(String id) {
		
		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		Good good = session.get(Good.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		return good;
	}

	public void delete(Good good) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.delete(good);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	public List<Good> findAllByAvailability(Boolean availability){
		
		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		String sql = "SELECT * FROM GOODS WHERE AVAILABILITY=:avial";
		
		Query query = session.createNativeQuery(sql, Good.class);
		
		query.setParameter("avial", availability);
		
		List<Good> goods = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		 
		return goods;
	}
}