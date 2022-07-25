package com.tudip.spring_boot_starter.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudip.spring_boot_starter.dto.CartItemDTO;

import com.tudip.spring_boot_starter.entity.Product;
import com.tudip.spring_boot_starter.service.CartItemService;


@RestController
public class CartItemResource {

	@Autowired
	private CartItemService cartItemService;
	
	
	
	@PostMapping({"/adddNewProduct"})
	public Product addNewProduct( @RequestBody    Product product) {

		return cartItemService.addNewProduct(product);
	}
	
		@RequestMapping("/product/{productId}")
		public  ResponseEntity<CartItemDTO> deleteProduct(@PathVariable ("productId") long productId) {
			return new ResponseEntity <CartItemDTO>(this.cartItemService.deleteProduct(productId),HttpStatus.OK);
			
			
		}
}