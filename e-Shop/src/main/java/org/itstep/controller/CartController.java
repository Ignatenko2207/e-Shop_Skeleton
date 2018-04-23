package org.itstep.controller;

import java.util.List;

import org.itstep.model.Cart;
import org.itstep.service.CartService;
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
@RequestMapping (path = "/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Cart> saveCart(@RequestBody Cart cart){
		if(cartService.save(cart) != null) {
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Cart> updateCart(@RequestBody Cart cart){
		if(cartService.update(cart) != null) {
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Cart> deleteCart(@RequestBody Cart cart){
		cartService.delete(cart);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping (path = "/get-one", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Cart> getCart(@RequestHeader Integer id){
		Cart cartFromDB = cartService.get(id);
		if(cartFromDB != null) {
			return new ResponseEntity<Cart>(cartFromDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping (path = "/get-list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<List<Cart>> getCartsByPeriod(@RequestHeader Long startPeriod, @RequestHeader Long endPeriod, @RequestBody String login ){
		List<Cart> cartsFromDB = cartService.findAllByCreationTime(startPeriod, endPeriod, login);
		if(cartsFromDB != null) {
			return new ResponseEntity<List<Cart>>(cartsFromDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
}
