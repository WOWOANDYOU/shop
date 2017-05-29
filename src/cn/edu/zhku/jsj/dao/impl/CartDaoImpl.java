package cn.edu.zhku.jsj.dao.impl;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.dao.CartDao;
import cn.edu.zhku.jsj.domain.Cart;

public class CartDaoImpl implements CartDao {
	//顾客选中物品加入购物车
	@Override
	public int add(Cart cart){
		return 0;
	}
	
	@Override
	public List<Map> findAll(){
		//查找 cart 表  将 购物项 找出
		//将信息存在 map集合 里（关键字是 order表的字段名 value是字段名对应值）然后再将map存在 list中,最后返回list集合
				
		return null;//
	}
	
	//修改商品的数量
	@Override
	public boolean update(int cart_id,int quantity){  //可以修改数量
		return false;
	}
	
	@Override
	public boolean delete(int cart_id){ 
		return false;
	}
	
	
}
