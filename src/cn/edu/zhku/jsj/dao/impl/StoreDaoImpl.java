package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.edu.zhku.jsj.dao.StoreDao;
import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.daomain.Store;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;

public class StoreDaoImpl implements StoreDao {
	//添加店铺 开店
	@Override
	public int add(Store store){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "insert into store values(null,?,?,?,?)";
			pres = con.prepareStatement(sql);
			pres.setString(1, store.getStorename());
			pres.setString(2, store.getOwner_id());
			pres.setString(3, store.getDescription());
			pres.setInt(4, store.getControl());
			
			int num = pres.executeUpdate();
			return num;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	//店铺中 查找商品
	@Override
	public List findProduce(int store_id,String produce_name){
		return null;//三张表查找  存在 map集合里 
	}
	
	
	//对三种商品信息更新  重载
	@Override
	public boolean updateInfo(Book book){
		return false;
	}
	
	@Override
	public boolean updateInfo(Food food){
		return false;
	}
	@Override
	public boolean updateInfo(Cloth cloth){
		return false;
	}
	
	//下架商品  三种商品
	@Override
	public boolean delete(Book book){
		return false;  
	}           
	            
	@Override
	public boolean delete(Food food){
		return false;  
	}           
	@Override
	public boolean delete(Cloth cloth){
		return false;
	}	
	
	
}
