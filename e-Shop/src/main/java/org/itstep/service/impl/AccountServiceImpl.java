package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.AccountDAO;
import org.itstep.model.Account;
import org.itstep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public Account save(Account account) {
		if (accountDAO.getOne(account.getLogin()) != null) {
			return accountDAO.save(account);
		}
		return null;
	}

	@Override
	public Account update(Account account) {
		if (accountDAO.getOne(account.getLogin()) != null) {
			return accountDAO.save(account);
		}
		return null;
	}

	@Override
	public Account get(String login) {
		return accountDAO.getOne(login);
	}

	@Override
	public void delete(String login) {
		Account account = accountDAO.getOne(login);
		if (account != null) {
			accountDAO.delete(account);
		}

	}

	@Override
	public List<Account> findAllByAccount() {
		return accountDAO.findAllByAccount();
	}

}
