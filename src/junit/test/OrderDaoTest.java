package junit.test;

import org.junit.Test;

import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;

public class OrderDaoTest {
	BusinessService bus = new BusinessServiceImpl();
	@Test
	public void testAdd(){
		Order o = new Order();
		o.setGood_id(1);
		o.setOrdertime(System.currentTimeMillis());
		o.setPrice(120);
		o.setQuantity(2);
		o.setStore_id(2);
		o.setUser_id("我就是叨叨");
		o.setState(2);
		int num = bus.addOrder(o);
		if(num!=0){
			System.out.println("插入成功");
		}
		
	}
}
