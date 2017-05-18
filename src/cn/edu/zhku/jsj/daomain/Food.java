package cn.edu.zhku.jsj.daomain;

public class Food {
	private int food_id;
<<<<<<< HEAD
	/*private String type;//记录种类
*/	private String foodname;
=======
	private String type;//记录种类
	private String foodname;
>>>>>>> 3bf1954899b0a9111d3e3346e221f3803295c2a9
	private float price;
	private String images;//记住 食物的各种图片
	private String description;
	private int store_id;  //外键 记住是哪家店的商品
	private int totalnum;   //货品的库存量
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
<<<<<<< HEAD
	
=======
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
>>>>>>> 3bf1954899b0a9111d3e3346e221f3803295c2a9
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	
}
