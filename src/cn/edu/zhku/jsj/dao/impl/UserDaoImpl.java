package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.jsj.dao.UserDao;
import cn.edu.zhku.jsj.daomain.User;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;

public class UserDaoImpl implements UserDao {
	
	//用户注册
	@Override
	public int add(User user){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		
		try{
			String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
			pres = con.prepareStatement(sql);   
			pres.setString(1, user.getUser_id());//user_id 表示 用户的账号 
			pres.setString(2, user.getNickname());
			pres.setString(3, user.getPassword());
			pres.setString(4, user.getPhonenum());
			pres.setString(5, user.getEmail());
			pres.setString(6, user.getAddress());
			pres.setString(7, user.getCardID());
			pres.setInt(8, user.getRole());  // 顾客默认为 1  顾客变为店家 是 改为 2
			pres.setString(9, user.getImage());
			
			int num = pres.executeUpdate();
			return num;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	//注册时查找 是否已经存在
	@Override
	public User find(String user_id){
		return null;
	}
	
	//用户登录
	@Override
	public User find(String user_id,String password){
		return null;
	}
}
