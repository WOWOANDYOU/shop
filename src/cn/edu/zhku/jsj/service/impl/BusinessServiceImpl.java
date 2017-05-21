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
import cn.edu.zhku.jsj.exception.UserexistException;
import cn.edu.zhku.jsj.factory.DaoFactory;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.web.utils.Md5;

public class BusinessServiceImpl implements BusinessService {
	private UserDao user_dao = DaoFactory.getInstance().createDao(UserDao.class); 
	private BookDao book_dao = DaoFactory.getInstance().createDao(BookDao.class); 
	private FoodDao food_dao = DaoFactory.getInstance().createDao(FoodDao.class); 
	private ClothDao cloth_dao = DaoFactory.getInstance().createDao(ClothDao.class); 
	
	private OrderDao order_dao = DaoFactory.getInstance().createDao(OrderDao.class); 
	private CartDao cart_dao = DaoFactory.getInstance().createDao(CartDao.class); 
	private OperatorDao ope_dao = DaoFactory.getInstance().createDao(OperatorDao.class); 
	private StoreDao store_dao = DaoFactory.getInstance().createDao(StoreDao.class); 
	
	//普通用户注册
	@Override
	public int adduser(User user) throws UserexistException{
		String user_id=user.getUser_id();
		//判断用户是否存在
		if(user_dao.find(user_id)!=null){
			throw new UserexistException("用户已经存在");
		}
		//采用md5码为用户密码加密
		String password=Md5.md5(user.getPassword());
		user.setPassword(password);
		//用户数据添加到数据库中
		int num = user_dao.add(user);
		return num;
	}
	
	//用户登录
	public User login(String user_id,String password){
		String userpassword=Md5.md5(password);
		return user_dao.find(user_id,userpassword);
	}
	//普通用户变为 店家
	@Override
	public int addshopkeeper(User user){
		int num = user_dao.add(user);
		return num;
	}
	
	//忘记密码时，查询用户是否存在
	public User check(String user_id,String phonenum,String email){
		User user=user_dao.find(user_id, phonenum, email);
		return user;
	}
	
	//用户忘记密码，修改密码
	public int changePassword(String user_id,String password){
		int num=user_dao.change(user_id, password);
		return num;
	}
	
	//开店铺   
	@Override
	public int addStore(Store store){
		int num = store_dao.add(store);
		return num;
	}
	
	//添加商品 book
	@Override
	public int addBook(Book book){
		int num = book_dao.add(book);
		return num;
	}
	
	//添加食物 
	@Override
	public int addFood(Food food){
		int num = food_dao.add(food);
		return num;
	}
	
	//添加 衣服
	@Override
	public int addCloth(Cloth cloth){
		int num = cloth_dao.add(cloth);
		return num;
	}
	
	 
}
