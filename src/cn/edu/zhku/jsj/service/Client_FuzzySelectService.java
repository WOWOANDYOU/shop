package cn.edu.zhku.jsj.service;

import java.util.List;

import cn.edu.zhku.jsj.dao.BookDao;
import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.dao.FoodDao;
import cn.edu.zhku.jsj.dao.impl.BookDaoImpl;
import cn.edu.zhku.jsj.dao.impl.ClothDaoImpl;
import cn.edu.zhku.jsj.dao.impl.FoodDaoImpl;
import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;

public class Client_FuzzySelectService {
	private BookDao bd=new BookDaoImpl(); 
	private FoodDao fd=new FoodDaoImpl();
	private ClothDao cd=new ClothDaoImpl();
	public List<Book> select_b(String str){
		List<Book> list=bd.findBook(str);
		return list;
	}
	public List<Food> select_f(String str){
		List<Food> list=fd.find(str);
		return list;
	}
	public List<Cloth> select_c(String str){
		List<Cloth> list=cd.find(str);
		return list;
	}
}
