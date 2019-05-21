package pers.arrayli.domain; 

/**
 * @author lzj13
 *	车费标准 bean
 */
public class CheFeiPrice {
	private int id;  		// 车费标准id
	private int price;		// 车费标准
	private String type; 	// 收费标准类型
	private String info;	// 简介
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "CheFeiPrice [id=" + id + ", price=" + price + ", type=" + type + ", info=" + info + "]";
	}
	
}
 