package cn.edu.zhku.jsj.dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.domain.Order;

public interface OrderDao {

	int add(Order order);

	List<Map> findAll();

	boolean delete(int order_id);

}