package cn.edu.zhku.jsj.service;

import java.util.List;

import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.daomain.Store;
import cn.edu.zhku.jsj.daomain.User;
import cn.edu.zhku.jsj.exception.UserexistException;

public interface BusinessService {

	// 普通用户注册
	int adduser(User user) throws UserexistException;

	// 用户登录
	User login(String user_id, String password);

	// 普通用户变为 店家
	int addshopkeeper(User user);

	// 忘记密码时，查询用户是否存在
	User check(String user_id, String phonenum, String email);

	// 用户忘记密码，修改密码
	int changePassword(String user_id, String password);

	// 开店铺
	int addStore(Store store);

	// 添加商品 book
	int addBook(Book book);

	// 添加食物
	int addFood(Food food);

	// 添加 衣服
	int addCloth(Cloth cloth);
	
	//店铺 展现所有 商品 （三种商品）
	List<Book> findstorebook(int store_id);
	List<Cloth> findstorecloth(int store_id);
	List<Food> findstorefood(int store_id);
	
	//根据 书籍id 查找书籍
	Book findbook(int book_id);
	//根据 衣服 id 查找
	Cloth findcloth(int cloth_id);
	//根据 food_id 查找 
	Food findfood(int food_id);
	
}