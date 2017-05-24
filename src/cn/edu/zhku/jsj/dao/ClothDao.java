package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.daomain.Cloth;

public interface ClothDao {

	int add(Cloth cloth);


	List<Cloth> find(String cloth_name);


	List<Cloth> findAll();

	List<Cloth> findCloth(int store_id);
	
	boolean update(Cloth cloth);


	boolean delete(int cloth_id);
	
	Cloth findcloth(int cloth_id);
}