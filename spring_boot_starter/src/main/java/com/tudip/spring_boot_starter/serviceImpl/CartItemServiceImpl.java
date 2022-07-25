package com.tudip.spring_boot_starter.serviceImpl;

import org.springframework.stereotype.Service;

import com.tudip.spring_boot_starter.dto.CartItemDTO;
import com.tudip.spring_boot_starter.entity.Product;


import com.tudip.spring_boot_starter.repository.CartItemRepository;
import com.tudip.spring_boot_starter.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Override
	public Product addNewProduct(Product product)
	{
		CartItemRepository.save(product);
	
    return product;
	}

	@Override
	public CartItemDTO deleteProduct(Object product) 
	{
		Long productName = null;
		
		CartItemRepository.deleteProduct(productName);
		
	    return deleteProduct(productName);
		
		
	}
   
	
}
