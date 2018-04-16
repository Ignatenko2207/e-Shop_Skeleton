package org.itstep.controller;

import org.itstep.model.Cart;
import org.itstep.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping (path = "/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Cart> saveCart(@RequestParam Cart cart){
		if(cartService.save(cart) != null) {
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Cart> updateCart(@RequestParam Cart cart){
		if(cartService.update(cart) != null) {
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
