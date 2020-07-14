package com.qa.ims.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDaoMysql;
import com.qa.ims.persistence.domain.Orderlines;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {
	
	public static final Logger LOGGER = Logger.getLogger(ProductController.class);
	
	private static String jdbcConnectionUrl;
	private static String username;
	private static String password;
	
	public OrderController(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/ims?serverTimezone=UTC"+"";
		this.username = username;
		this.password = password;
	}
	
	public OrderController(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}



	private CrudServices<Orders> orderService;
	
	public OrderController(CrudServices<Orders> orderService) {
		this.orderService = orderService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	

	
	static Orderlines orderlinesFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("orderId");
		Long orderLinesId = resultSet.getLong("orderLinesId");
		Long custId = resultSet.getLong("orderCustId");
		Long prodId = resultSet.getLong("prodId");
		int qty = resultSet.getInt("prodQty");
		double lineCost = resultSet.getDouble("lineCost");
		return new Orderlines(orderId, orderLinesId, custId, prodId, qty, lineCost);
	}
	
	
	// prints all the orderlines using the order Id
//	public void orderlinesById(long id) {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();
//				
//				ResultSet resultSetOrderLines = statement.executeQuery("select * from orderlines where orderId = " + id);
//				 ) {
//			
//			
//			while(resultSetOrderLines.next()) {
//				LOGGER.info(orderlinesFromResultSet(resultSetOrderLines));
//				
//			}
//			
//		}catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = orderService.readAll();
		ArrayList<Orderlines> orderlines = new ArrayList<>();
		int counter = 0;
		for(Orders order: orders) {
			LOGGER.info(order.toString());
			
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSetOrderLines = statement.executeQuery("select * from orderlines where orderId = " + orders.get(counter).getOrderId());
					 ) {
				
				
				while(resultSetOrderLines.next()) {
					orderlines.add(orderlinesFromResultSet(resultSetOrderLines));
					LOGGER.info(orderlinesFromResultSet(resultSetOrderLines));
					
				}
				
			}catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			counter++ ;
			
			
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
		prodIdArray.add(Integer.valueOf(getInput()));
		LOGGER.info("Please enter the Quantity you want to order");
		prodQtyArray.add(Integer.valueOf(getInput()));
		LOGGER.info("Please enter 1 to add more or 2 to continue (you can add 14 more items)");
		int option =0;
		option = Integer.valueOf(getInput());
		int addMore =0;
		switch(option){
		
		case 1:
			for(int i =1; i <15; i++) {
				
				LOGGER.info("Please enter the ID of the Product you want to order");
				prodIdArray.add(Integer.valueOf(getInput()));
				LOGGER.info("Please enter the Quantity you want to order");
				prodQtyArray.add(Integer.valueOf(getInput()));
				
				LOGGER.info("Add more? Enter 1 for yes or 2 for no");
				
				addMore = Integer.valueOf(getInput());
				
				if (addMore == 2) {
					break;
				}
				
				
			}
			break;
			
		case 2:
			break;
			
		}
		
		
		
		Orders order = OrderDaoMysql.createOrder(custId, prodIdArray, prodQtyArray);
//		LOGGER.info("Product created");
		
		return order;
	}

	@Override
	public Orders update() {
		
		System.out.println("Orders cannot be updated");
		
		//not required in the spec
		
//		readAll();
//		
//		LOGGER.info("Please enter the order ID you want to make changes to ");
//		orderlinesById(Long.valueOf(getInput()));
//		LOGGER.info("Please enter the orderlines ID you want to update");
//		Long orderlinesId = Long.valueOf(getInput());
//		LOGGER.info("Please enter the new product Id");
//		Long prodId = (Long.valueOf(getInput()));
//		LOGGER.info("Please enter the new Product Quantity");
//		int qty = getInputInt();
//		Orders orderlines = orderService.update(new Orders(orderlinesId, name, price, qty));
//		return orderlines;
		return null;
		
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the Order you would like to delete");
		Long id = Long.valueOf(getInput());
		
		orderService.delete(id);
	}

}
