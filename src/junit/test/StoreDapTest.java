package junit.test;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.StoreDaoImpl;
import cn.edu.zhku.jsj.domain.Store;

public class StoreDapTest {
	@Test
	public void addTest(){
		Store sto = new Store();
		sto.setStorename("美宜佳");
		sto.setOwner_id("我就是叨叨");
		sto.setDescription("这是一家便利店");
		
		StoreDaoImpl storedao = new StoreDaoImpl();
		storedao.add(sto);
	}
	
	@Test
	public void ClassTest(){
		System.out.println(Store.class.getName());
	}
}
