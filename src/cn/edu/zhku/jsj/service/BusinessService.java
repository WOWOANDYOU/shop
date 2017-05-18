package cn.edu.zhku.jsj.service;

import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.daomain.Store;
import cn.edu.zhku.jsj.daomain.User;
import cn.edu.zhku.jsj.exception.UserexistException;

public interface BusinessService {

	//普通用户注册
	int adduser(User user) throws UserexistException;
	
	//用户登录
	User login(String user_id,String password);
	
	//普通用户变为 店家
	int addshopkeeper(User user);

	//开店铺   
	int addStore(Store store);

	//添加商品 book
	int addBook(Book book);

	//添加食物 
	int addFood(Food food);

	//添加 衣服
	int addCloth(Cloth cloth);

}