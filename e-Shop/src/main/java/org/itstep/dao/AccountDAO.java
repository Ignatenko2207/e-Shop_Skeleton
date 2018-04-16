package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.Account;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	HibernateUtil hiber;
	
	public Account save(Account account) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.saveOrUpdate(account);
		
		session.getTransaction().commit();
		session.close();
		
		if(getOne(account.getLogin()) != null) {
			return account;
		}
		
		return null;
	}

	public Account getOne(String login) {
		
		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		Account account = session.get(Account.class, login);
		
		session.getTransaction().commit();
		session.close();
		
		return account;
	}

	public void delete(Account account) {

		Session session = hiber.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		session.delete(account);;
		
		session.getTransaction().commit();
		session.close();
	}
}
