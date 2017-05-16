package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;

public class ClothDaoImpl implements ClothDao {
	@Override
	public int add(Cloth cloth){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "insert into cloth values(null,?,?,?,?,?,?,?,?,?)";
			pres = con.prepareStatement(sql);
			
			pres.setString(1, cloth.getClothname());
			pres.setString(2, cloth.getVersion());
			pres.setFloat(3, cloth.getPrice());
			pres.setInt(4,cloth.getTotalnum());
			pres.setString(5, cloth.getSize());
			pres.setString(6, cloth.getColor());
			pres.setString(7, cloth.getImages());
			pres.setString(8, cloth.getDescription());
			pres.setInt(9, cloth.getStore_id());
			
			int num = pres.executeUpdate();
			return num;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public Cloth find(String cloth_name){
		return null;
	}
	
	@Override
	public List<Cloth> findAll(){
		return null;
	}
	
	@Override
	public boolean update(Cloth cloth){
		return false;
	}
	
	@Override
	public boolean delete(Cloth cloth){
		return false;
	}
}	
