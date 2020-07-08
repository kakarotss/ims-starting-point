package com.qa.ims.persistence.domain;

public class Product {
	
	private Long id;
	private String Name;
	private double Price;
	private int qty;
	
	
	public Product(Long id, String name, double price, int qty) {
		super();
		this.id = id;
		Name = name;
		Price = price;
		this.qty = qty;
	}


	public Product(String name, double price, int qty) {
		super();
		Name = name;
		Price = price;
		this.qty = qty;
	}
	
	public Product() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", Name=" + Name + ", Price=" + Price + ", qty=" + qty + "]";
	}
	
	
	
	

}
