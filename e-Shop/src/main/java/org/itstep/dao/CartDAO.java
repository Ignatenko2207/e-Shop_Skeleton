package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.itstep.model.Cart;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAO{

	@Autowired
	HibernateUtil hiber;
	
	public Cart save(Cart cart) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.saveOrUpdate(cart);
		
		session.getTransaction().commit();
		session.close();
		
		if(getOne(cart.getId()) != null) {
			return cart;
		}
		
		return null;
	}

	public Cart getOne(Integer id) {
		
		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		Cart cart = session.get(Cart.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		return cart;
	}

	public void delete(Cart cart) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.delete(cart);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	public List<Cart> findAllByCreationTime(Long startPeriod, Long endPeriod, String login){
		
		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		String sql = "SELECT * FROM CARTS WHERE CREATION_TIME>:startPeriod AND CREATION_TIME<:endPeriod AND ACCOUNT_LOGIN=:login";
		
		Query query = session.createNativeQuery(sql, Cart.class);
		
		query.setParameter("startPeriod", startPeriod);
		query.setParameter("endPeriod", endPeriod);
		query.setParameter("login", login);
		
		List<Cart> carts = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		 
		return carts;
	}
	
}
