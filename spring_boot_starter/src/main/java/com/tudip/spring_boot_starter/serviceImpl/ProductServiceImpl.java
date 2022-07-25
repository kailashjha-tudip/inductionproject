package com.tudip.spring_boot_starter.serviceImpl;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.tudip.spring_boot_starter.dto.ProductDTO;
import com.tudip.spring_boot_starter.entity.Product;
import com.tudip.spring_boot_starter.exception.ResourceNotFoundException;
import com.tudip.spring_boot_starter.repository.ProductRepository;
import com.tudip.spring_boot_starter.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository productrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ProductServiceImpl(ProductRepository productrepo, ModelMapper modelMapper) {
		this.productrepo = productrepo;
		this.modelMapper = modelMapper;
	}
	private ProductDTO mapToDTO(Product product) {
		ProductDTO Productdto = modelMapper.map(product, ProductDTO.class);
		return Productdto;
	}

	private Product mapToEntity(ProductDTO product) {
		Product saveproduct = modelMapper.map(product, Product.class);
		return saveproduct;
	}
	
	@Override
	public ProductDTO addNewProduct(ProductDTO productdto) {
		if(productdto.getName().isEmpty() ) {
			throw new ResourceNotFoundException("Input field are empty ");
		}
		Product products= mapToEntity(productdto);
		Product saveproducts = productrepo.save(products);

		return mapToDTO(saveproducts);
	}
	@Override
	public ProductDTO updateProduct(ProductDTO productdto) {
		try {
			Product product = mapToEntity(productdto);

			long productId = product.getId();
			Optional<Product> products = productrepo.findById(productId);
			if (products.isPresent()) {
				Product saveproducts=productrepo.save(products);
				return mapToDTO(saveproducts);
			} else {
				throw new ResourceNotFoundException("No record found in database");
			}

		} catch (Exception e) {
			throw new ResourceNotFoundException("No record found in database ");
		}
	}
	@Override
	public Page<Product> getProduct(Pageable pageable) {
		try {
			return (Page<Product>) productrepo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("User record not found");
		}
	}
	@Override
	public ProductDTO getProduct(long productId) {
		try {
			Optional<Product> product = productrepo.findById(productId);
			if (product.isPresent()) {
				return mapToDTO(product.get());
			} else {
				throw new ResourceNotFoundException("Users id Not Found");
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Users id Not Found");
		}
	}
	

}
