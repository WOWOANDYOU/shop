package cn.edu.zhku.jsj.dao;

import cn.edu.zhku.jsj.daomain.User;

public interface UserDao {

	//用户注册
	int add(User user);

	//注册时查找 是否已经存在
	User find(String user_id);

	//用户登录
	User find(String user_id, String password);

}