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
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.Product;

@RunWith(MockitoJUnitRunner.class)
public class OrderDaoMysqlTest {
	
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
	public void orderCreateTest() {
		
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");

		Long id = 1L;
		ArrayList <Integer> prodId = new ArrayList<>(); 
		ArrayList <Integer> prodQty = new ArrayList<>(); 
		assertEquals(null, OrderDaoMysql.createOrder(id, prodId, prodQty));

	}
	
	
	
	@Test
	public void orderReadAllTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		List<Orders> order = new ArrayList<>();
		order.add(new Orders());
		
		assertNotEquals(order, orderDaoMysql.readAll());
	}
	
	
	@Test
	public void prodReadLatestTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Product product = new Product(2L, "Nike sequent 4", 110.0, 150);
		assertNotEquals(product, orderDaoMysql.readLatest());
	}
	
	@Test
	public void readProductTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Product product = new Product(1L, "Nike air max 270", 125, 200);
		assertNotEquals(product, orderDaoMysql.readProducts(1L));
	}
	

	
	@Test
	public void orderDeleteTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		String id = "1";
		orderDaoMysql.delete(Long.parseLong(id));
		List<Orders> order = new ArrayList<>();
		order.add(new Orders());
		assertNotEquals(order, orderDaoMysql.readAll());
	}
	

}
