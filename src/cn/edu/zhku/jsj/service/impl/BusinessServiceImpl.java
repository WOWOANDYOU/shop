package cn.edu.zhku.jsj.service.impl;

import cn.edu.zhku.jsj.dao.BookDao;
import cn.edu.zhku.jsj.dao.CartDao;
import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.dao.FoodDao;
import cn.edu.zhku.jsj.dao.OperatorDao;
import cn.edu.zhku.jsj.dao.OrderDao;
import cn.edu.zhku.jsj.dao.StoreDao;
import cn.edu.zhku.jsj.dao.UserDao;
import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.daomain.Store;
import cn.edu.zhku.jsj.daomain.User;
import cn.edu.zhku.jsj.factory.DaoFactory;

public class BusinessServiceImpl {
	private UserDao user_dao = DaoFactory.getInstance().createDao(UserDao.class); 
	private BookDao book_dao = DaoFactory.getInstance().createDao(BookDao.class); 
	private FoodDao food_dao = DaoFactory.getInstance().createDao(FoodDao.class); 
	private ClothDao cloth_dao = DaoFactory.getInstance().createDao(ClothDao.class); 
	
	private OrderDao order_dao = DaoFactory.getInstance().createDao(OrderDao.class); 
	private CartDao cart_dao = DaoFactory.getInstance().createDao(CartDao.class); 
	private OperatorDao ope_dao = DaoFactory.getInstance().createDao(OperatorDao.class); 
	private StoreDao store_dao = DaoFactory.getInstance().createDao(StoreDao.class); 
	
	//普通用户注册
	public int adduser(User user){
		int num = user_dao.add(user);
		return num;
	}
	//普通用户变为 店家
	public int addshopkeeper(User user){
		int num = user_dao.add(user);
		return num;
	}
	//开店铺   
	public int addStore(Store store){
		int num = store_dao.add(store);
		return num;
	}
	
	//添加商品 book
	public int addBook(Book book){
		int num = book_dao.add(book);
		return num;
	}
	
	//添加食物 
	public int addFood(Food food){
		int num = food_dao.add(food);
		return num;
	}
	
	//添加 衣服
	public int addCloth(Cloth cloth){
		int num = cloth_dao.add(cloth);
		return num;
	}
	
	 
}
