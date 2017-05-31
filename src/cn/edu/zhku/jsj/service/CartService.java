package cn.edu.zhku.jsj.service;

import cn.edu.zhku.jsj.dao.CartDao;
import cn.edu.zhku.jsj.dao.impl.CartDaoImpl;
import cn.edu.zhku.jsj.domain.Cart;

public class CartService {
	private CartDao cd=new CartDaoImpl();
	public boolean addCart(Cart cart){
		int message=cd.add(cart);
		if(message!=0){
		return true;
		}
		return false;
	}
	public int countCart(String user_id){
		int num=cd.countCart(user_id);
		return num;
	}
}
