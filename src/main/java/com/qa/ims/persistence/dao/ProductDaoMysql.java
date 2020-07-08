package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

public class ProductDaoMysql implements Dao<Product>{
	public static final Logger LOGGER = Logger.getLogger(ProductDaoMysql.class);
	
	
	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ProductDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/ims?serverTimezone=UTC"+"";
		this.username = username;
		this.password = password;
	}
	
	public ProductDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	
	Product productFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("prodId");
		String Name = resultSet.getString("prodName");
		double Price = resultSet.getDouble("prodPrice");;
		int qty = resultSet.getInt("prodQty");;
		return new Product(id, Name, Price, qty);
	}

	@Override
	public List<Product> readAll() {
		
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from products");) {
			ArrayList<Product> products = new ArrayList<>();
			while (resultSet.next()) {
				products.add(productFromResultSet(resultSet));
			}
			return products;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	
	public Product readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM products ORDER BY prodId DESC LIMIT 1");) {
			resultSet.next();
			return productFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Product create(Product product) {

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into products(prodName, prodPrice, prodQty) values('" + product.getName()
					+ "','" + product.getPrice() + "','"+ product.getQty() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Product update(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}