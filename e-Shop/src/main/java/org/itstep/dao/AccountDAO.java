package org.itstep.dao;

import java.util.List;

import org.itstep.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<Account, String> {

    List<Account> findAllByAccount();

}
