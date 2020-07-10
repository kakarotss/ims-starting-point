package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDaoMysql;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {
	
	public static final Logger LOGGER = Logger.getLogger(ProductController.class);

	private CrudServices<Orders> orderService;
	
	public OrderController(CrudServices<Orders> orderService) {
		this.orderService = orderService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	double getInputDouble() {
		return Utils.getInputDouble();
	}
	
	int getInputInt() {
		return Utils.getInputInt();
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = orderService.readAll();
		for(Orders order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Orders create() {
		ArrayList<Integer> prodIdArray = new ArrayList<Integer>();
		ArrayList<Integer> prodQtyArray = new ArrayList<Integer>();
		int [][] orderInfo = new int[10][1];
		LOGGER.info("Please enter a customer ID you want to make an order for");
		Long custId = Long.valueOf(getInput());
		LOGGER.info("Please enter the ID of the Product you want to order");
		prodIdArray.add(getInputInt());
		LOGGER.info("Please enter the Quantity you want to order");
		prodQtyArray.add(getInputInt());
		LOGGER.info("Please enter 1 to add more or 2 to continue (you can add 14 more items)");
		int option =0;
		option = getInputInt();
		int addMore =0;
		switch(option){
		
		case 1:
			for(int i =1; i <15; i++) {
				
				LOGGER.info("Please enter the ID of the Product you want to order");
				prodIdArray.add(getInputInt());
				LOGGER.info("Please enter the Quantity you want to order");
				prodQtyArray.add(getInputInt());
				
				LOGGER.info("Add more? Enter 1 for yes or 2 for no");
				
				addMore = getInputInt();
				
				if (addMore == 2) {
					break;
				}
				
				
			}
			break;
			
		case 2:
			break;
			
		}
		
		
		
		Orders order = OrderDaoMysql.createOrder(custId, prodIdArray, prodQtyArray);
		LOGGER.info("Product created");
		
		return order;
	}

	@Override
	public Orders update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
