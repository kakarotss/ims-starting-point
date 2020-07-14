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

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.services.OrderServices;
import com.qa.ims.services.ProductServices;


@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private OrderServices orderServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy // for the methods in customerController
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private OrderController orderController;
	
	@Before
	public void setUp(){
		orderController = new OrderController(orderServices);
	}

	@Test
	public void readAllTest() {
		
		List<Orders> orders = new ArrayList<>();
		orders.add(new Orders(1L, 1L, 1L, 20.0, 2, 40.0));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}
	
	
}
