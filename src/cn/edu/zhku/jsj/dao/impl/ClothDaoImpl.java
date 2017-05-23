package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.management.RuntimeErrorException;

import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;
import cn.edu.zhku.jsj.web.utils.ResultToBean;

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
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		Cloth cloth = null;
		List<Cloth> clothlist;
		try{
			String sql = "select * from cloth where clothname=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, cloth_name);
			rs = pres.executeQuery();
			
			clothlist = ResultToBean.getBeanList(Cloth.class, rs); //调工具类 （封装 数据到 bean的工具类）
			for(Cloth clothitem:clothlist){
				cloth = clothitem;
			}
			return cloth;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public List<Cloth> findAll(){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		Cloth cloth = null;
		List<Cloth> clothlist;
		try{
			String sql = "select * from cloth";
			pres = con.prepareStatement(sql);
			rs = pres.executeQuery();
			
			clothlist = ResultToBean.getBeanList(Cloth.class, rs); //调工具类 （封装 数据到 bean的工具类）
			return clothlist;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public boolean update(Cloth cloth){
		boolean b = false;
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "update cloth set version=?,price=?,totalnum=?,description=? where cloth_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, cloth.getVersion());
			pres.setFloat(2, cloth.getPrice());
			pres.setInt(3, cloth.getTotalnum());
			pres.setString(4, cloth.getDescription());
			pres.setInt(5, cloth.getCloth_id());
			
			int num = pres.executeUpdate();
			if(num!=0){
				b = true;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return b;
	}
	
	@Override
	public boolean delete(int cloth_id){
		boolean b = false;
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "delete from cloth where cloth_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, cloth_id);
			int num = pres.executeUpdate();
			if(num!=0){
				b = true;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return b;
	}

	@Override
	public List<Cloth> findCloth(int store_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		Cloth cloth = null;
		List<Cloth> clothlist;
		try{
			String sql = "select * from cloth where store_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, store_id);
			rs = pres.executeQuery();
			
			clothlist = ResultToBean.getBeanList(Cloth.class, rs); //调工具类 （封装 数据到 bean的工具类）
			
			return clothlist;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
}	
