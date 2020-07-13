package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	private Product product;
	private Product product2;
	
	@Before
	public void setUp() {
		product = new Product(1L, "nike sommin", 50.0, 6);
		product2 = new Product(1L, "adidas sommin", 60.0, 2);
	}
	
	@Test
	public void gettersSettersTest() {
		assertNotNull(product.getId());
		assertNotNull(product.getName());
		assertNotNull(product.getPrice());
		assertNotNull(product.getQty());
		
		product.setId(null);
		assertNull(product.getId());
		product.setName(null);
		assertNull(product.getName());
		product.setPrice(0);
		product.getPrice();
		product.setQty(0);
		product.getQty();
		assertNull(product.getId());
		assertNull(product.getName());
		assertEquals(0, (int) product.getPrice());
		assertEquals(0, product.getQty());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(product.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(product.equals(new Object()));
	}
	
	@Test
	public void createProductWithId() {
		assertEquals(1L, product.getId(), 0);
		assertEquals("nike sommin", product.getName());
		assertEquals(50, (int) product.getPrice());
		assertEquals(6, product.getQty());
		

	
	}
	
	@Test
	public void checkEquality() {
		assertTrue(product.equals(product));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertFalse(product.equals(product2));
	}
	
	@Test
	public void productNameNullButOtherNameNotNull() {
		product.setName(null);
		assertFalse(product.equals(product2));
	}
	
	@Test
	public void NameNotEqual() {
		product2.setName("slazanger");;
		assertFalse(product.equals(product2));
	}
	
//	@Test
//	public void checkEqualityBetweenDifferentObjectsNullName() {
//		product.setName(null);
//		product.setPrice(2.0);
//		product.setQty(3);
//		product2.setName(null);
//		product2.setPrice(2.0);
//		product2.setQty(3);
//		assertTrue(product.equals(product2));
//	}
//	
	@Test
	public void nullId() {
		product.setId(null);
		product2.setId(1L);
		assertFalse(product.equals(product2));
	}
	
	@Test
	public void nullIdOnBoth() {
		product.setId(null);
		product2.setId(null);
		assertEquals(product.getId(), product2.getId());
	}
	
	@Test
	public void otherIdDifferent() {
		product2.setId(2L);
		assertFalse(product.equals(product2));
	}
	
	@Test
	public void nullName() {
		product.setName(null);
		assertFalse(product.equals(product2));
	}
	
	@Test
	public void nullNameOnBoth() {
		product.setName(null);
		product2.setName(null);
		assertEquals(product.getName(), product2.getName());
	}
	
	@Test
	public void product2NameDifferent() {
		product2.setName("something else");
		assertFalse(product.equals(product2));
	}
	
	@Test
	public void noPrice() {
		product.setPrice(0);
		assertFalse(product.equals(product2));
	}
	
	@Test
	public void noPriceOnBoth() {
		product.setPrice(0);
		product2.setPrice(0);
		assertTrue(product.getPrice() == product2.getPrice());
	}
	
	@Test
	public void product2PriceDifferent() {
		product.setPrice(12321);
		assertFalse(product.equals(product2));
	}
	
	@Test
	public void constructorWitId() {
		Product product = new Product(1L, "Shenron", 232, 4);
		assertNotNull(product.getId());
		assertNotNull(product.getName());
		assertNotNull(product.getPrice());
		assertNotNull(product.getQty());
	}
	
	@Test
	public void constructorWithoutId() {
		Product product = new Product("Shenron", 232, 4);
		assertNull(product.getId());
		assertNotNull(product.getName());
		assertNotNull(product.getPrice());
		assertNotNull(product.getQty());
	}
	
	@Test
	public void constructorWithoutParam() {
		Product productT = new Product();
		
	}
	
	
	
	@Test
	public void toStringTest() {
		String toString = "Product [id=" + 1L + ", Name=nike sommin, Price=" + 50.0 + ", qty=" + 6 + "]";
		assertEquals(toString, product.toString());
	}
}
