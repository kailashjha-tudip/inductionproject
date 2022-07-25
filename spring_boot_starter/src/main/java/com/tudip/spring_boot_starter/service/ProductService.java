package com.tudip.spring_boot_starter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tudip.spring_boot_starter.dto.ProductDTO;
import com.tudip.spring_boot_starter.entity.Product;

public interface ProductService {

	public ProductDTO addNewProduct(ProductDTO product);

	public ProductDTO updateProduct(ProductDTO productdto);

	public Page<Product> getProduct(Pageable pageable);

	public ProductDTO getProduct(long productId);

}
