package cn.edu.zhku.jsj.service.impl;

import java.util.List;

import cn.edu.zhku.jsj.dao.BookDao;
import cn.edu.zhku.jsj.dao.CartDao;
import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.dao.FoodDao;
import cn.edu.zhku.jsj.dao.OperatorDao;
import cn.edu.zhku.jsj.dao.OrderDao;
import cn.edu.zhku.jsj.dao.StoreDao;
import cn.edu.zhku.jsj.dao.UserDao;
import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.domain.User;
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

	@Override
	public List<Book> findstorebook(int store_id) {
		List<Book> booklist = book_dao.findBook(store_id);
		return booklist;
	}

	@Override
	public List<Cloth> findstorecloth(int store_id) {
		List<Cloth> clothlist = cloth_dao.findCloth(store_id);
		return clothlist;
	}

	@Override
	public List<Food> findstorefood(int store_id) {
		List<Food> foodlist = food_dao.findFood(store_id);
		return foodlist;
	}

	@Override
	public Book findbook(int book_id) {
		Book book = book_dao.findbook(book_id);
		return book;
	}

	@Override
	public Cloth findcloth(int cloth_id) {
		Cloth cloth = cloth_dao.findcloth(cloth_id);
		return cloth;
	}

	@Override
	public Food findfood(int food_id) {
		Food food = food_dao.findfood(food_id);
		return food;
	}

	@Override
	public boolean updateBook(Book book) {
		 return book_dao.update(book);
		
	}

	@Override
	public boolean updateFood(Food food) {
		return food_dao.update(food);
	}

	@Override
	public boolean updateCloth(Cloth cloth) {
		return cloth_dao.update(cloth);
	}

	@Override
	public boolean deletebook(int book_id) {
		boolean b = book_dao.delete(book_id);
		return b;
	}

	@Override
	public boolean deletefood(int food_id) {
		boolean b = food_dao.delete(food_id);
		return b;
	}

	@Override
	public boolean deletecloth(int cloth_id) {
		boolean b = cloth_dao.delete(cloth_id);
		return b;
	}

	@Override
	public List<Book> search_book(int store_id, String goodname) {
		return book_dao.search_book(store_id, goodname);
	}

	@Override
	public List<Food> search_food(int store_id, String goodname) {
		return food_dao.search_food(store_id, goodname);
	}

	@Override
	public List<Cloth> search_cloth(int store_id, String goodname) {
		return cloth_dao.search_cloth(store_id, goodname);
	}

	@Override
	public Store finstoreinfo(int store_id) {
		return store_dao.findstoreinfo(store_id);
	}

	@Override
	public boolean updatestore_info(Store store) {
		return store_dao.updatestore(store);
	}

	@Override
	public List<Order> getOrder(int store_id) {
		return order_dao.getstore_Orders(store_id);
	}

	@Override
	public int addOrder(Order order) {
		int num = order_dao.add(order);
		return num;
	}

	@Override
	public List<Order> getBFOrder(int store_id, int states) {
		return order_dao.getstore_BFOrders(store_id,states);
	}

	
}
