package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Product;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ProductController implements CrudController<Product>{
	
	public static final Logger LOGGER = Logger.getLogger(ProductController.class);

	private CrudServices<Product> productService;
	
	public ProductController(CrudServices<Product> productService) {
		this.productService = productService;
	}
	
	
	String getInput() {
		return Utils.getInput();
	}
	
//	double getInputDouble() {
//		return Utils.getInputDouble();
//	}
//	
//	int getInputInt() {
//		return Utils.getInputInt();
//	}
	
	
	@Override
	public List<Product> readAll() {
		
		List<Product> products = productService.readAll();
		for(Product product: products) {
			LOGGER.info(product.toString());
		}
		System.out.println();
		return products;
	}

	@Override
	public Product create() {
		LOGGER.info("Please enter a Product Name");
		String prodName = getInput();
		LOGGER.info("Please enter the Price");
		double prodPrice = Integer.valueOf(getInput());
		LOGGER.info("Please enter the Quantity available");
		int prodQty = Integer.valueOf(getInput());
		Product product = productService.create(new Product(prodName, prodPrice, prodQty));
		System.out.println();
		
		return product;
	}

	@Override
	public Product update() {
		// TODO Auto-generated method stub
		
		LOGGER.info("Please enter the id of the product you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter the new Product Name");
		String name = getInput();
		LOGGER.info("Please enter the new Product Price");
		double price = Double.valueOf(getInput());
		LOGGER.info("Please enter the new Product Quantity");
		int qty = Integer.valueOf(getInput());
		Product product = productService.update(new Product(id, name, price, qty));
		System.out.println();
		return product;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the product you would like to delete");
		Long id = Long.valueOf(getInput());
		
		productService.delete(id);
		LOGGER.info("Product deleted");
		System.out.println();
		
		
	}

}
