package cn.edu.zhku.jsj.dao.impl;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.dao.OrderDao;
import cn.edu.zhku.jsj.daomain.Order;

public class OrderDaoImpl implements OrderDao {
	@Override
	public int add(Order order){
		return 0;
	}
	@Override
	public List<Map> findAll(){
		//查找 order 表  将 订单项（可能是书 食物或者衣服）
		//将信息存在 map集合 里（关键字是 order表的字段名 value是字段名对应值）然后再将map存在 list中,最后返回list集合
		return null;
	}
	@Override
	public boolean delete(int order_id){
		return false;
	}
}
