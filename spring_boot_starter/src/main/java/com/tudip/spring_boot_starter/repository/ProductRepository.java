package com.tudip.spring_boot_starter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tudip.spring_boot_starter.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
     
	//@Query("select p from product where status = true and id=Id")
	Optional<Product> findById(long  Id);

	Product save(Optional<Product> products);

}
