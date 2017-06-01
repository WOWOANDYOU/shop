package cn.edu.zhku.jsj.dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.domain.Order;

public interface OrderDao {

	int add(Order order);

	List<Map> findAll();

	boolean delete(int order_id);
	
	List<Order> getstore_Orders(int store_id);
	
	List<Order> getstore_BFOrders(int store_id,int states);
	
	boolean updateState(int order_id);

	List<Order> findOrder(String user_id);

	List<Order> findOrder(String user_id, int state);
	
}