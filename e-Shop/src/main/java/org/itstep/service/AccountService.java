package org.itstep.service;

import org.itstep.model.Account;

public interface AccountService {

	Account save(Account account);

	Account update(Account account);

	Account get(String login);

	void delete(Account account);

}
