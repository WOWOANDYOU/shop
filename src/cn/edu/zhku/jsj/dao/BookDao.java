package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.daomain.Book;

public interface BookDao {

	//添加图书
	int add(Book book);

	Book findBook(String book_name);

	List<Book> findAll();

	boolean update(Book book);

	boolean delete(int book_id);

}