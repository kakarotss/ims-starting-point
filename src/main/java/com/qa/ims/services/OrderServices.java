package com.qa.ims.services;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders;



public class OrderServices implements CrudServices<Orders>{
	
private Dao<Orders> orderDao;
	
	public OrderServices(Dao<Orders> orderDao) {
		this.orderDao = orderDao;
	}


	@Override
	public List<Orders> readAll() {
		return orderDao.readAll();
	}

	@Override
	public Orders create(Orders t) {
		return orderDao.create(t);
	}

	@Override
	public Orders update(Orders t) {
		return orderDao.update(t);
	}

	@Override
	public void delete(Long id) {
		orderDao.delete(id);
		
	}

}
