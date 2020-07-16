package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoMysqlTest {
	
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
	public void custCreateTest() {
		
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		String firstName = "Arbab";
		String surname = "Ahm";
		Customer customer = new Customer(3L, firstName, surname);
		String firstName2 = "sommin";
		String surname2 = "21";
		Customer customer2 = new Customer(4L, firstName2, surname2);
		assertEquals(customer, customerDaoMysql.create(customer));
		assertEquals(customer2, customerDaoMysql.create(customer2));
	}
	
	@Test
	public void custReadAllTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "Arbab", "Ahmed"));
		customers.add(new Customer(2L, "sommin", "21"));

		assertEquals(customers, customerDaoMysql.readAll());
	}
	
	
	@Test
	public void custReadLatestTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Customer customer = new Customer(2L, "Vinesh", "Ghela");
		assertEquals(customer, customerDaoMysql.readLatest());
	}
	
	@Test
	public void ReadCustomerTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Customer customer = new Customer(1L, "Arbab", "Ahmed");
		assertEquals(customer, customerDaoMysql.readCustomer(1L));
	}
	
	@Test
	public void custUpdateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		Long id = 2L;
		String firstName = "Vinesh";
		String surname = "Ghela";
		Customer customer = new Customer((id), firstName, surname);
		assertEquals(customer, customerDaoMysql.update(customer));
	}
	
	@Test
	public void custDeleteTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.89.71.26:3306/ims_test?serverTimezone=UTC", "root", "root");
		String id = "2";
		customerDaoMysql.delete(Long.parseLong(id));
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "Arbab", "Ahmed"));
		customers.add(new Customer(3L, "Arbab", "Ahm"));
		customers.add(new Customer(4L, "sommin", "21"));
		assertEquals(customers, customerDaoMysql.readAll());
	}

//	@AfterClass
//	public static void cleanDB() {
//
//		try (Connection connection = DriverManager.getConnection(jdbcurl, username, password);
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("drop table customers");
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//	}
	
	
	
	@Test
	public void constructorTest() {
		
		CustomerDaoMysql dao = new CustomerDaoMysql("testing", "the", "constructor");
	}
	
	@Test
	public void constructorTest2() {
		
		OrderDaoMysql dao = new OrderDaoMysql("testing", "the", "constructor");
	}
	
	@Test
	public void constructorTest3() {
		
		OrderDaoMysql dao = new OrderDaoMysql("the", "constructor");
	}
	
	@Test
	public void constructorTest4() {
		
		ProductDaoMysql dao = new ProductDaoMysql("the", "constructor");
	}
	
	@Test
	public void constructorTest5() {
		
		ProductDaoMysql dao = new ProductDaoMysql("testing", "the", "constructor");
	}

	
	

	
	
	
	

}
