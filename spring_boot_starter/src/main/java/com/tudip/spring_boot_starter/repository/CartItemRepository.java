 package com.tudip.spring_boot_starter.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.tudip.spring_boot_starter.entity.Product;
import com.tudip.spring_boot_starter.entity.cartItem;


public interface CartItemRepository extends JpaRepository<cartItem, Long> {

	static void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	static void deleteProduct(Long productName) {
		// TODO Auto-generated method stub
		
	}
    

 

}
