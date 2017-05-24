package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.edu.zhku.jsj.dao.BookDao;
import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;
import cn.edu.zhku.jsj.web.utils.ResultToBean;

public class BookDaoImpl implements BookDao {
	
	//添加图书
	@Override
	public int add(Book book){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "insert into book values(null,?,?,?,?,?,?,?,?,?,?)";
			pres = con.prepareStatement(sql);
			
			pres.setString(1, book.getBookname());
			pres.setString(2, book.getAuthor());
			pres.setString(3, book.getPress());
			pres.setInt(4,book.getTotalnum());
			pres.setFloat(5, book.getPrice());
			pres.setString(6, book.getVersion());
			pres.setString(7, book.getImages());
			pres.setString(8, book.getISBN());
			pres.setString(9, book.getDescription());
			pres.setInt(10, book.getStore_id());
			
			int num = pres.executeUpdate();
			return num;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public List<Book> findBook(String book_name){


		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List <Book> list= new ArrayList();
		Book book=null;
		try{
			String sql = "select * from book where bookname like ?";

			pres = con.prepareStatement(sql);
			pres.setString(1, "%"+book_name+"%");
			
			rs = pres.executeQuery();
			if(rs.next()){
				book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setImages(rs.getString("B_images"));
				book.setBook_id(rs.getInt("book_id"));
				book.setBookname(rs.getString("bookname"));
				book.setDescription(rs.getString("B_description"));
				book.setISBN(rs.getString("ISBN"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getFloat("B_price"));
				book.setTotalnum(rs.getInt("totalnum"));
				book.setStore_id(rs.getInt("B_store_id"));
				book.setVersion(rs.getString("B_version"));
				list.add(book);
				
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return list;
		
	}
	@Override
	public List<Book> findAll(){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Book> list = new LinkedList<Book>();
		Book book = null;
		try{
			String sql = "select * from book";
			pres = con.prepareStatement(sql);			
			rs = pres.executeQuery();
			
 			while(rs.next()){
				book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setImages(rs.getString("B_images"));
				book.setBook_id(rs.getInt("book_id"));
				book.setBookname(rs.getString("bookname"));
				book.setDescription(rs.getString("B_description"));
				book.setISBN(rs.getString("ISBN"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getFloat("B_price"));
				book.setTotalnum(rs.getInt("totalnum"));
				book.setStore_id(rs.getInt("B_store_id"));
				book.setVersion(rs.getString("B_version"));
				list.add(book);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return list;
	}
	
	@Override
	public boolean update(Book book){ 
		boolean b = false;
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "update book set totalnum=?,price=?,version=?,description=? where book_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, book.getTotalnum());
			pres.setFloat(2, book.getPrice());
			pres.setString(3, book.getVersion());
			pres.setString(4, book.getDescription());
			pres.setInt(5, book.getBook_id());
			int num =  pres.executeUpdate();
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
	public boolean delete(int book_id){
		boolean b = false;
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "delete from book where book_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, book_id);
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
	public List<Book> findBook(int store_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Book> booklist = new LinkedList<Book>();
		try{
			String sql = "select * from book where store_id=?";
			pres = con.prepareStatement(sql);	
			pres.setInt(1, store_id);
			rs = pres.executeQuery();
			booklist = ResultToBean.getBeanList(Book.class, rs); //调工具类 （封装 数据到 bean的工具类）
 			/*while(rs.next()){
				book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setImages(rs.getString("B_images"));
				book.setBook_id(rs.getInt("book_id"));
				book.setBookname(rs.getString("bookname"));
				book.setDescription(rs.getString("B_description"));
				book.setISBN(rs.getString("ISBN"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getFloat("B_price"));
				book.setTotalnum(rs.getInt("totalnum"));
				book.setStore_id(rs.getInt("B_store_id"));
				book.setVersion(rs.getString("B_version"));
				list.add(book);
			}*/
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return booklist;
	}

	@Override
	public Book findbook(int book_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Book> booklist = new LinkedList<Book>();
		Book book = null;
		try{
			String sql = "select * from book where book_id=?";
			pres = con.prepareStatement(sql);	
			pres.setInt(1, book_id);
			rs = pres.executeQuery();
			booklist = ResultToBean.getBeanList(Book.class, rs); //调工具类 （封装 数据到 bean的工具类）
			book = booklist.get(0);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return book;
	}
	
}
