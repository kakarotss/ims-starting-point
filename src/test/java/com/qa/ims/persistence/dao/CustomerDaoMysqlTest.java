package com.qa.ims.persistence.dao;

import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoMysqlTest {
	
	
	@Before
	public void constructorSetup() {
		
		CustomerDaoMysql dao = new CustomerDaoMysql("testing", "the", "constructor");
	}
	
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
