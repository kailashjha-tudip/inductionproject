package com.tudip.spring_boot_starter.service;


import com.tudip.spring_boot_starter.dto.CartItemDTO;
import com.tudip.spring_boot_starter.entity.Product;

public interface CartItemService {

	Product addNewProduct(Product product);

	CartItemDTO deleteProduct(Object productId);
	
	

}
