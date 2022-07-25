package com.tudip.spring_boot_starter.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tudip.spring_boot_starter.dto.ProductDTO;
import com.tudip.spring_boot_starter.entity.Product;
import com.tudip.spring_boot_starter.service.ProductService;

@RestController
public class ProductResource 
{
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping({"/product"})
	public ResponseEntity <ProductDTO> addNewProduct( @RequestBody    ProductDTO productdto) {

		return new ResponseEntity<ProductDTO>(this.productService.addNewProduct (productdto),HttpStatus.OK);
}
	//update the product
	@PutMapping("/product")
	public ResponseEntity <ProductDTO> updateProduct(@RequestBody ProductDTO productdto) {
		return new ResponseEntity <ProductDTO>(this.productService.updateProduct(productdto),HttpStatus.OK);
	}
	
	@GetMapping("/product")
	public Page<Product> getProduct(Pageable pageable ){
		return this.productService.getProduct(pageable);
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable ("productId") long productId) {
		return new ResponseEntity <ProductDTO>(this.productService.getProduct(productId),HttpStatus.OK);
	}
	
}