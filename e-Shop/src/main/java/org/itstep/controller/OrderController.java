package org.itstep.controller;

import org.itstep.model.GoodOrder;
import org.itstep.service.OrderService;
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
@RequestMapping(path = "/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<GoodOrder> saveOrder(@RequestBody GoodOrder order){
		
		if (orderService.save(order) != null) {
			return new ResponseEntity<GoodOrder>(order, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<GoodOrder> updateOrder(@RequestBody GoodOrder order){
		
		if (orderService.save(order) != null) {
			return new ResponseEntity<GoodOrder>(order, HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<GoodOrder> deleteOrder(@RequestBody GoodOrder order){
		orderService.delete(order);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping ( produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<GoodOrder> getOrder(@RequestHeader Integer id){
		GoodOrder orderFromDB = orderService.get(id);
		if(orderFromDB != null) {
			return new ResponseEntity<GoodOrder>(orderFromDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
