package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.ProductRepository;
import com.app.entity.Product;

@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepo;
	@Override
	public Product getProductDetails(int productId) {
		
		return productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Invalid productId..!, product with given productId doesn't exits..!"));
	}
	
}
