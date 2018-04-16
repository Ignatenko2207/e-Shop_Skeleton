package org.itstep.service.impl;

import org.itstep.dao.AccountDAO;
import org.itstep.model.Account;
import org.itstep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public Account save(Account account) {
		if (accountDAO.getOne(account.getLogin()) != null) {
			return accountDAO.save(account);
		}
		return null;
	}

	public Account update(Account account) {
		if (accountDAO.getOne(account.getLogin()) != null) {
			return accountDAO.save(account);
		}
		return null;
	}

	public Account get(String login) {
		return accountDAO.getOne(login);
	}

	public void delete(Account account) {
		accountDAO.delete(account);
	}
}
