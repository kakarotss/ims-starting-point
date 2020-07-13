package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrdersTest {
	
	private Orders order;
//	private Orders order2;
	
	@Before
	public void setUp() {
//		Long orderId, Long orderCustId, Long orderProdId, double total, int orderqty, double lineCost
		order = new Orders(1L, 1L, 1L, 200, 4, 50);
//		order2 = new Orders(2L, 2L, 2L, 100, 2, 50);
	}
	
	@Test
	public void gettersSettersTest() {
		assertNotNull(order.getLineCost());
		assertNotNull(order.getOrderCustId());
		assertNotNull(order.getOrderId());
		assertNotNull(order.getOrderProdId());
		assertNotNull(order.getOrderqty());
		assertNotNull(order.getTotal());
		
		
		
		order.setLineCost(0);
		order.setOrderCustId(null);
		order.setOrderId(null);
		order.setOrderProdId(null);
		order.setOrderqty(0);
		order.setTotal(0);
		assertNull(order.getOrderCustId());
		assertNull(order.getOrderId());
		assertNull(order.getOrderProdId());
		assertEquals(0, (int) order.getLineCost());
		assertEquals(0, order.getOrderqty());
		assertEquals(0, (int) order.getTotal());
		
	
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	
	@Test
	public void constructer1test() {
		Orders ord1 = new Orders(1L, 1L, 200, 2, 100);
		
		assertTrue(ord1.equals(ord1));
		

	
	}

	@Test
	public void constructer2test() {
		Orders ord2 = new Orders(1L, 1L, 200);
		

		
	}
	
	@Test
	public void constructer3test() {
		Orders ord3 = new Orders(1L);
		

	
	}
	
	@Test
	public void constructerEmptytest() {
		Orders ord4 = new Orders();
		

	
	}
	
	
	@Test
	public void toStringTest() {
		String toString = "Orders [orderId=" + 1 + ", orderCustId=" + 1 + ", Total=" + 200.0 + "]";
		assertEquals(toString, order.toString());
		
	}
	
	

}
