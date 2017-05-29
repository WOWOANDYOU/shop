package cn.edu.zhku.jsj.service;

import java.util.List;

import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.daomain.Operator;
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
	
	//注册开店
	 int registerEmplooyer(String user_id ,String cardID ,int role);
	 
	//用户修改个人信息
	 int changemessage(User user);
	 
	//用户登录时，查看自己的店铺
	Store findMyStore(String owner_id);
	 
	//用户修改个人资料后，更新session中的user
	User findInformation(String user_id);

	// 开店铺
	int addStore(Store store);
	
	//管理员的登录时间的数据库
	 int setTime(Operator operator);
	 
	//管理员的查看店铺的信息
	List storeInformation();
	
	//管理员根据店铺名查找店铺
	Store operator_find(String storename);
	
	//店铺管理，查封与解封
	 int storecontrol(int control,String storename);

	// 添加商品 book
	int addBook(Book book);

	// 添加食物
	int addFood(Food food);

	// 添加 衣服
	int addCloth(Cloth cloth);
	
	//添加管理员
	int addOperator(Operator operator);
	
	//管理员登录
	Operator findOperator(String name,String password);

}