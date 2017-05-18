package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.edu.zhku.jsj.dao.OperatorDao;
import cn.edu.zhku.jsj.daomain.Operator;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;

public class OperatorDaoImpl implements OperatorDao {
	@Override
	public int add(Operator operator){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql = "insert into operator values(null,?,?,?)";
		try {
			pres = con.prepareStatement(sql);
			pres.setString(1, operator.getName());
			pres.setString(2, operator.getPassword());
			
			long time = operator.getLoginTime().getTime();
			Timestamp timestamp = new Timestamp(time);
			pres.setTimestamp(3, timestamp);
			
			int num = pres.executeUpdate();
			return num;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	//运营人员登录
	@Override
	public boolean find(String name,String password){
		return false;
	}
}
