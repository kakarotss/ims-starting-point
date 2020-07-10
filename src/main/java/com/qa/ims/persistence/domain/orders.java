package com.qa.ims.persistence.domain;

public class orders {
	
	private Long orderId;
	private Long orderCustId;
	private Long orderProdId;
	private double Total;
	private int orderqty;
	private double lineCost;
	
	public orders(Long orderId, Long orderCustId, Long orderProdId, double total, int orderqty, double lineCost) {
		super();
		this.orderId = orderId;
		this.orderCustId = orderCustId;
		this.orderProdId = orderProdId;
		Total = total;
		this.orderqty = orderqty;
		this.lineCost = lineCost;
	}

	public orders(Long orderCustId, Long orderProdId, double total, int orderqty, double lineCost) {
		super();
		this.orderCustId = orderCustId;
		this.orderProdId = orderProdId;
		Total = total;
		this.orderqty = orderqty;
		this.lineCost = lineCost;
	}
	
	public orders() {
		
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

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
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
}
