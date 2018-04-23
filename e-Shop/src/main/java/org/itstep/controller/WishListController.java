package org.itstep.controller;

import org.itstep.model.WishList;
import org.itstep.service.WishListService;
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
@RequestMapping(path = "/wishList")
public class WishListController {

	@Autowired
	WishListService wishListService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<WishList> saveWishList(@RequestBody WishList wishList){
		
		if (wishListService.save(wishList) != null) {
			return new ResponseEntity<WishList>(wishList, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<WishList> updateWishList(@RequestBody WishList wishList){
		
		if (wishListService.save(wishList) != null) {
			return new ResponseEntity<WishList>(wishList, HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping ( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<WishList> deleteWishList(@RequestBody WishList wishList){
		wishListService.delete(wishList);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping ( produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<WishList> getWishList(@RequestHeader Integer id){
		WishList wishListFromDB = wishListService.get(id);
		if(wishListFromDB != null) {
			return new ResponseEntity<WishList>(wishListFromDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
