package cn.edu.zhku.jsj.dao;

import cn.edu.zhku.jsj.daomain.User;

public interface UserDao {

	//用户注册
	int add(User user);

	//注册时查找 是否已经存在
	User find(String user_id);

	//用户登录时的查找
	User find(String user_id, String password);

	//忘记登录密码查询时
	User find(String user_id, String phonenum, String email) ;
	
	// 忘记密码时，修改密码
    int change(String user_id, String password);
}