package com.qa.ims.persistence.domain;

public class Orderlines {
	
	private Long orderId;
	private Long orderLinesId;
	private Long orderCustId;
	private Long orderProdId;
	private int orderqty;
	private double lineCost;
	
	
	public Orderlines(Long orderId, Long orderCustId, Long orderProdId, int orderqty, double lineCost) {
		super();
		this.orderId = orderId;
		this.orderCustId = orderCustId;
		this.orderProdId = orderProdId;
		this.orderqty = orderqty;
		this.lineCost = lineCost;
	}
	
	
	public Long getOrderLinesId() {
		return orderLinesId;
	}


	public void setOrderLinesId(Long orderLinesId) {
		this.orderLinesId = orderLinesId;
	}


	public Orderlines(Long orderId, Long orderLinesId, Long orderCustId, Long orderProdId, int orderqty,
			double lineCost) {
		super();
		this.orderId = orderId;
		this.orderLinesId = orderLinesId;
		this.orderCustId = orderCustId;
		this.orderProdId = orderProdId;
		this.orderqty = orderqty;
		this.lineCost = lineCost;
	}


	public Orderlines() {
		
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Long getOrderCustId() {
		return orderCustId;
	}


	public void setOrderCustId(Long orderCustId) {
		this.orderCustId = orderCustId;
	}


	public Long getOrderProdId() {
		return orderProdId;
	}


	public void setOrderProdId(Long orderProdId) {
		this.orderProdId = orderProdId;
	}


	public int getOrderqty() {
		return orderqty;
	}


	public void setOrderqty(int orderqty) {
		this.orderqty = orderqty;
	}


	public double getLineCost() {
		return lineCost;
	}


	public void setLineCost(double lineCost) {
		this.lineCost = lineCost;
	}


	@Override
	public String toString() {
		return "Orderlines [orderId=" + orderId + ", orderLinesId=" + orderLinesId + ", orderCustId=" + orderCustId
				+ ", orderProdId=" + orderProdId + ", orderqty=" + orderqty + ", lineCost=" + lineCost + "]";
	}



	
	
	

}
