package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderlinesTest {
	
	private Orderlines orderline;
	
	@Before
	public void setUp() {
		
//		s(Long orderId, Long orderLinesId, Long orderCustId, Long orderProdId, int orderqty,
//		double lineCost) 
		orderline = new Orderlines(1L, 1L, 1L, 1L, 4, 200);

	}
	
	@Test
	public void gettersSettersTest() {
		assertNotNull(orderline.getLineCost());
		assertNotNull(orderline.getOrderCustId());
		assertNotNull(orderline.getOrderId());
		assertNotNull(orderline.getOrderLinesId());
		assertNotNull(orderline.getOrderProdId());
		assertNotNull(orderline.getOrderqty());

		
		orderline.setLineCost(0);
		orderline.setOrderCustId(null);
		orderline.setOrderId(null);
		orderline.setOrderLinesId(null);
		orderline.setOrderProdId(null);
		orderline.setOrderqty(0);
		
		assertNull(orderline.getOrderCustId());
		assertNull(orderline.getOrderId());
		assertNull(orderline.getOrderLinesId());
		assertNull(orderline.getOrderProdId());
		
		assertEquals(0, (int) orderline.getLineCost());
		assertEquals(0, orderline.getOrderqty());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(orderline.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(orderline.equals(new Object()));
	}
	
	
	@Test
	public void constructer1test() {
//		Long orderId, Long orderCustId, Long orderProdId, int orderqty, double lineCost
		
		Orderlines line1 = new Orderlines(1L,1L,1L,25,3789);
		

	
	}


	
	@Test
	public void constructerEmptytest() {
		Orderlines line2 = new Orderlines();
		

	
	}
	
	
	@Test
	public void toStringTest() {
//		"Orderlines [orderId=" + 1L + ", orderLinesId=" + 1L + ", orderCustId=" + 1L
//		+ ", orderProdId=" + 1L + ", orderqty=" + 4 + ", lineCost=" + 200.0 + "]"
		String toString = "Orderlines [orderId=" + 1L + ", orderLinesId=" + 1L + ", orderCustId=" + 1L
				+ ", orderProdId=" + 1L + ", orderqty=" + 4 + ", lineCost=" + 200.0 + "]";
		assertEquals(toString, orderline.toString());
		
	}
	
	

}
