package junit.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.UserDaoImpl;
import cn.edu.zhku.jsj.daomain.User;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;

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
	
	@Test
	public void rsTest(){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "select * from book";
			pres = con.prepareStatement(sql);
			rs = pres.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("数据库列数 "+rsmd.getColumnCount());
			/*String name = rsmd.getColumnLabel(1);
			System.out.println(name);
			System.out.println(rsmd.getColumnLabel(2));
			*/
			String name = "";
			while(rs.next()){
				for(int i=1;i<=rsmd.getColumnCount();i++){
					name = rsmd.getColumnLabel(i);
					Object value = rs.getObject(name);
					Class<?> type = value.getClass();
					System.out.println(type);
				}
				
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			
		}
	}
}
