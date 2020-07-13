package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderlines;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

public class OrderDaoMysql implements Dao<Orders>{
	
	public static final Logger LOGGER = Logger.getLogger(ProductDaoMysql.class);
	
	
	private static String jdbcConnectionUrl;
	private static String username;
	private static String password;

	public OrderDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/ims?serverTimezone=UTC"+"";
		this.username = username;
		this.password = password;
	}
	
	public OrderDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	
	static Orders orderFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("orderId");
		Long custId = resultSet.getLong("orderCustId");
		Double total = resultSet.getDouble("Total");
//		String Name = resultSet.getString("prodName");
//		double Price = resultSet.getDouble("prodPrice");;
//		int qty = resultSet.getInt("prodQty");;
		return new Orders(orderId, custId, total);
	}
	
	static Orderlines orderlinesFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("orderId");
		Long custId = resultSet.getLong("orderCustId");
		Long prodId = resultSet.getLong("prodId");
		int qty = resultSet.getInt("prodQty");
		double lineCost = resultSet.getDouble("lineCost");
		return new Orderlines(orderId, custId, prodId, qty, lineCost);
	}
	
	static Product productFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("prodId");
		String Name = resultSet.getString("prodName");
		double Price = resultSet.getDouble("prodPrice");;
		int qty = resultSet.getInt("prodQty");;
		return new Product(id, Name, Price, qty);
	}
	
	public static Orders readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderId DESC LIMIT 1");) {
			resultSet.next();
			return orderFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public static Product readProducts(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE prodId ="+ id );) {
			resultSet.next();
			return productFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public static Orders createOrder(Long custId, ArrayList <Integer> prodIds, ArrayList <Integer> prodQtys) {
		
		
		
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders(orderCustId, total) values('" + custId
					+ "','" + 0 + "')");
			
			
			
//			LOGGER.info("Product Created");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		
		Long orderId = readLatest().getOrderId();
		
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			
			double Total= 0;
			for(int i = 0; i < prodIds.size(); i++) {
				
				double price = readProducts((long) prodIds.get(i)).getPrice();
				Total = Total+price*prodQtys.get(i);
				
				
			statement.executeUpdate("insert into orderLines(orderId, orderCustId, prodId, prodQty, lineCost) values(" + orderId
					+ "," + custId + "," + prodIds.get(i) + ""+ "," + prodQtys.get(i) + ""+ "," + price*prodQtys.get(i) + ""+ ")");

			}
			System.out.println("update orders set total =" + Total + "WHERE orderId =" + orderId);
			
			statement.executeUpdate("update orders set total =" + Total + " WHERE orderId =" + orderId);
			
			LOGGER.info("Orderlines inserted");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		
		
		return null;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				Statement statement2 = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");
				 ) {
			ArrayList<Orders> orders = new ArrayList<>();
//			ArrayList<Orderlines> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				
//				ResultSet resultSetOrderLines = statement2.executeQuery("select * from orderlines where orderId = " + resultSet.getLong("orderId"));
//				System.out.println("select * from orderlines where orderId = " + resultSet.getLong("orderId"));
				orders.add(orderFromResultSet(resultSet));
				
//				while(resultSetOrderLines.next()) {
//					orderlines.add(orderlinesFromResultSet(resultSetOrderLines));
//					
//				}
				
			}
			
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Orders create(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders update(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				Statement statement2 = connection.createStatement();) {
			statement.executeUpdate("delete from orderlines where orderId = " + id);
			statement.executeUpdate("delete from orders where orderId = " + id);
			LOGGER.info("Order deleted");
			
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		
	}

}
