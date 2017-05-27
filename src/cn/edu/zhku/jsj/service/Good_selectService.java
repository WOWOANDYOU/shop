package cn.edu.zhku.jsj.service;

import cn.edu.zhku.jsj.dao.BookDao;
import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.dao.FoodDao;
import cn.edu.zhku.jsj.dao.StoreDao;
import cn.edu.zhku.jsj.dao.impl.BookDaoImpl;
import cn.edu.zhku.jsj.dao.impl.ClothDaoImpl;
import cn.edu.zhku.jsj.dao.impl.FoodDaoImpl;
import cn.edu.zhku.jsj.dao.impl.StoreDaoImpl;
import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;

public class Good_selectService {
	private BookDao bd = new BookDaoImpl();
	private FoodDao fd = new FoodDaoImpl();
	private ClothDao cd = new ClothDaoImpl();
	public Book findbook(int book_id){
		Book b=bd.findbook(book_id);
		return b;
	}
	public Food findfood(int food_id){
		Food f=fd.findfood(food_id);
		return f;
	}
	public Cloth findcloth(int cloth_id){
		Cloth c=cd.findcloth(cloth_id);
		return c;
	}
}
