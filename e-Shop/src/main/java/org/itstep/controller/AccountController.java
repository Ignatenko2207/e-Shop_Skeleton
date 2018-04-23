package org.itstep.controller;

import org.itstep.model.Account;
import org.itstep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Account> saveAccount(@RequestBody Account account){
		
		if (accountService.save(account) != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Account> updateAccount(@RequestBody Account account){
		
		if (accountService.save(account) != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Account> deleteAccount(@RequestBody Account account){
		accountService.delete(account);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping ( produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Account> getAccount(@RequestHeader String login){
		Account accountFromDB = accountService.get(login);
		if(accountFromDB != null) {
			return new ResponseEntity<Account>(accountFromDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
