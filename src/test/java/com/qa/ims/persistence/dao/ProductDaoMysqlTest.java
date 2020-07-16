package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoMysqlTest {
	
	public static final Logger LOGGER = Logger.getLogger(Ims.class);
	static String jdbcurl = "jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC";
	static String username = "root";
	static String password = "root";
	
	
	
	
	@BeforeClass
	public static void testInit() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql://" + "34.89.71.26:3306" + "/ims_test?serverTimezone=UTC "+"", "root", "root", "src/test/resources/sql-schema.sql");
		
	}
	
	
	@Test
	public void prodCreateTest() {
		
		ProductDaoMysql productDaoMysql = new ProductDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Long id = 3L;
		String name = "prod1";
		double price = 20;
		int qty = 2;
		Product product = new Product(id, name, price, qty);
		assertNotEquals(product, productDaoMysql.create(product));

	}
	
	@Test
	public void prodReadAllTest() {
		ProductDaoMysql productDaoMysql = new ProductDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		List<Product> product = new ArrayList<>();
		product.add(new Product(1L, "Nike air max 270", 125.0, 200));
		product.add(new Product(2L, "Nike sequent 4", 110.0, 150));
		product.add(new Product(3L, "prod1", 20.0, 2));
		
		assertNotEquals(product, productDaoMysql.readAll());
	}
	
	@Test
	public void prodReadLatestTest() {
		ProductDaoMysql productDaoMysql = new ProductDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Product product = new Product(2L, "Nike sequent 4", 110.0, 150);
		assertNotEquals(product, productDaoMysql.readLatest());
	}
	
	@Test
	public void readProductTest() {
		ProductDaoMysql productDaoMysql = new ProductDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Product product = new Product(1L, "Nike air max 270", 125, 200);
		assertNotEquals(product, productDaoMysql.readProduct(1L));
	}
	
	@Test
	public void productUpdateTest() {
		ProductDaoMysql productDaoMysql = new ProductDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Long id = 2L;
		String Name = "Nike sequent 5";
		double price = 200.0;
		int qty = 25;
		Product product = new Product(id, Name, price, qty);
		assertNotEquals(product, productDaoMysql.update(product));
	}
	
	@Test
	public void custDeleteTest() {
		ProductDaoMysql productDaoMysql = new ProductDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		String id = "2";
		productDaoMysql.delete(Long.parseLong(id));
		List<Product> product = new ArrayList<>();
		product.add(new Product(1L, "Nike air max 270", 125, 200));
		assertNotEquals(product, productDaoMysql.readAll());
	}
	

}
