package org.itstep.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.model.Account;
import org.itstep.model.Cart;
import org.itstep.model.Good;
import org.itstep.model.GoodOrder;
import org.itstep.model.WishList;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {

	private final SessionFactory sessionFactory = configureSessionFactory();

	/**
	 * Create SessionFactory
	 * 
	 * @return {@link SessionFactory}
	 * @throws HibernateException
	 */
	private SessionFactory configureSessionFactory() throws HibernateException {

		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Good.class);
		configuration.addAnnotatedClass(GoodOrder.class);
		configuration.addAnnotatedClass(Cart.class);
		configuration.addAnnotatedClass(WishList.class);

		return configuration.buildSessionFactory();

	}

	/**
	 * Get SessionFactory
	 * 
	 * @return {@link SessionFactory}
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}