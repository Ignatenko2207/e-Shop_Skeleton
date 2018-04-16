package org.itstep.service;

import java.util.List;

import org.itstep.model.Account;

public interface AccountService {

	Account save(Account account);

	Account update(Account account);

	Account get(String login);

	void delete(String login);

	List<Account> findAllByAccount();
}
