package cn.edu.zhku.jsj.formbean;

import java.util.HashMap;
import java.util.Map;

public class FoodFormBean {
	private String foodname;
	private String fooddescription;
	private float foodprice;
	private int foodtotalnum;
	private Map<String,String> errormap = new HashMap<String,String>();
	public String getFoodname() {
		return foodname;
	}
	public Map<String, String> getErrormap() {
		return errormap;
	}
	public void setErrormap(Map<String, String> errormap) {
		this.errormap = errormap;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getFooddescription() {
		return fooddescription;
	}
	public void setFooddescription(String fooddescription) {
		this.fooddescription = fooddescription;
	}
	public float getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(float foodprice) {
		this.foodprice = foodprice;
	}
	public int getFoodtotalnum() {
		return foodtotalnum;
	}
	public void setFoodtotalnum(int foodtotalnum) {
		this.foodtotalnum = foodtotalnum;
	}
	public boolean checkoutData(){
		boolean b = false;
		if(this.foodname==null || this.foodname.trim().equals("")){
			errormap.put("foodname", "商品名称不能为空");
			return b;
		}
		if(this.foodprice==0){
			errormap.put("foodprice", "商品单价不能为空且只能填入数字");
			return b;
		}
		if(this.foodtotalnum==0){
			errormap.put("foodtotalnum", "商品库存不能为空且只能填入数字");
			return b;
		}
		if(this.fooddescription==null || this.fooddescription.trim().equals("")){
			errormap.put("fooddescription", "商品描述不能为空");
			return b;
		}
		b = true;
		return b;
	}
	
}
