package junit.test;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.ClothDaoImpl;
import cn.edu.zhku.jsj.daomain.Cloth;

public class ClothDaoTest {
	@Test
	public void addTest(){
		Cloth cloth = new Cloth();
		cloth.setClothname("秋衣男款");
		cloth.setColor("黑色");
		cloth.setDescription("物美价廉");
		cloth.setImages("d://1.jpg");
		cloth.setPrice(50);
		cloth.setSize("S;M;L;XL;XXL");
		cloth.setStore_id(1);
		cloth.setTotalnum(59);
		cloth.setVersion("潮流款;小清新;均码");
		
		ClothDaoImpl clothdao = new ClothDaoImpl();
		clothdao.add(cloth);
	}
	
	@Test
	public void findClothTest(){
		ClothDaoImpl clothdao = new ClothDaoImpl();
		Cloth cloth = clothdao.find("秋衣男款");
		System.out.println(cloth.getCloth_id());
		System.out.println(cloth.getPrice());
	}
}
