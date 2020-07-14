package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Product;
//import com.qa.ims.services.CustomerServices;
import com.qa.ims.services.ProductServices;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private ProductServices productServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy // for the methods in customerController
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private ProductController productController;
	
	@Before
	public void setUp(){
		productController = new ProductController(productServices);
	}

	@Test
	public void readAllTest() {
		
		List<Product> product = new ArrayList<>();
		product.add(new Product(1L, "prod", 20.0, 2));
		Mockito.when(productServices.readAll()).thenReturn(product);
		assertEquals(product, productController.readAll());
	}
	
	
//	@Test
//	public void createTest() {
//		String id = "1";
//		String name = "name";
//		String price = "2.0";
//		String qty = "3";
//		Mockito.doReturn(id, name, price, qty).when(productController).getInput();
//		Product product = new Product( "name", 2.0, 3);
////		Customer savedCustomer = new Customer(1L, "Chris", "Perrins");
//		Mockito.when(productServices.create(product)).thenReturn(product);
//		assertEquals(product, productController.create());
//	}




}
