package cn.edu.zhku.jsj.daomain;

public class Cloth {
	private int cloth_id;
<<<<<<< HEAD
	/*private String type;//记录种类
*/	private String clothname;
=======
	private String type;//记录种类
	private String clothname;
>>>>>>> 3bf1954899b0a9111d3e3346e221f3803295c2a9
	private float price;
	private String color;  //颜色选择
	private String size;
	private String version;
	private String images;//记住衣服 的各种图片
	private String description;
	private int store_id;  //外键 记住是那哪店的商品
	private int totalnum;   //货品的库存量
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public int getCloth_id() {
		return cloth_id;
	}
	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
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
	public String getClothname() {
		return clothname;
	}
	public void setClothname(String clothname) {
		this.clothname = clothname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
