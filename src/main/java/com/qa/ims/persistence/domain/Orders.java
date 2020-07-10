package com.qa.ims.persistence.domain;

public class Orders {
	
	private Long orderId;
	private Long orderCustId;
	private Long orderProdId;
	private double Total;
	private int orderqty;
	private double lineCost;
	
	public Orders(Long orderId, Long orderCustId, Long orderProdId, double total, int orderqty, double lineCost) {
		super();
		this.orderId = orderId;
		this.orderCustId = orderCustId;
		this.orderProdId = orderProdId;
		Total = total;
		this.orderqty = orderqty;
		this.lineCost = lineCost;
	}

	public Orders(Long orderCustId, Long orderProdId, double total, int orderqty, double lineCost) {
		super();
		this.orderCustId = orderCustId;
		this.orderProdId = orderProdId;
		Total = total;
		this.orderqty = orderqty;
		this.lineCost = lineCost;
	}
	
	
	
	public Orders(Long orderId, Long orderCustId, double total) {
		super();
		this.orderId = orderId;
		this.orderCustId = orderCustId;
		Total = total;
	}
	
	public Orders(Long orderCustId) {
		super();
		this.orderCustId = orderCustId;
	
	}

	public Orders() {
		
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

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderCustId=" + orderCustId + ", Total=" + Total + "]";
	}
	
	
	
	
}
