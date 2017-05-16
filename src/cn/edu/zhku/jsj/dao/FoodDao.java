package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.daomain.Food;

public interface FoodDao {

	int add(Food food);

	Food find(String food_name);

	List<Food> findAll();

	boolean update(Food food);

	boolean delete(int food_id);

}