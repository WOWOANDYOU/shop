package cn.edu.zhku.jsj.dao.impl;

import java.util.List;

import cn.edu.zhku.jsj.dao.FoodDao;
import cn.edu.zhku.jsj.daomain.Food;

public class FoodDaoImpl implements FoodDao {
	@Override
	public int add(Food food){
		return 0;
	}
	
	@Override
	public Food find(String food_name){
		return null;
	}
	
	@Override
	public List<Food> find(){
		return null;
	}
	
	@Override
	public boolean update(Food food){
		return false;
	}
	
	@Override
	public boolean delete(Food food){
		return false;
	}
}	
