package org.itstep.controller;

import java.util.List;

import org.itstep.model.Good;
import org.itstep.service.GoodService;
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
@RequestMapping(path = "/good")
public class GoodController {

	@Autowired
	GoodService goodService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Good> saveGood(@RequestBody Good good){
		
		if (goodService.save(good) != null) {
			return new ResponseEntity<Good>(good, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Good> updateGood(@RequestBody Good good){
		
		if (goodService.save(good) != null) {
			return new ResponseEntity<Good>(good, HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Good> deleteGood(@RequestBody Good good){
		goodService.delete(good);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping ( path = "/get-one", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Good> getGood(@RequestHeader String login){
		Good goodFromDB = goodService.get(login);
		if(goodFromDB != null) {
			return new ResponseEntity<Good>(goodFromDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping ( path = "/get-by-availability", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<List<Good>> findAllByAvailability(@RequestHeader Boolean availability){
		List<Good> goodsFromDB = goodService.findAllByAvailability(availability);
		if(goodsFromDB != null) {
			return new ResponseEntity<List<Good>>(goodsFromDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
