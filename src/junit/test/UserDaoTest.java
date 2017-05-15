package junit.test;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.UserDaoImpl;
import cn.edu.zhku.jsj.daomain.User;

public class UserDaoTest {
	@Test
	public void addTest(){
		User user = new User();
		user.setUser_id("叨叨就是刀刀");
		user.setNickname("我就是我");
		user.setPassword("123");
		user.setPhonenum("12345678911");
		user.setEmail("12123@sina.com");
		user.setAddress("广东省哈市");
		user.setRole(1);  
		user.setCardID(null);
		user.setImage("c://haha.jpg");
		UserDaoImpl userdao = new UserDaoImpl();
		userdao.add(user);
	}
}
