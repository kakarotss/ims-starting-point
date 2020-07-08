package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Product;

public class ProductServices implements CrudServices<Product> {
	
	private Dao<Product> productDao;
	
	public ProductServices(Dao<Product> productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	@Override
	public Product create(Product t) {
		return productDao.create(t);
	}

	@Override
	public Product update(Product t) {
		return productDao.update(t);
	}

	@Override
	public void delete(Long id) {
		productDao.delete(id);
		
	}

}
