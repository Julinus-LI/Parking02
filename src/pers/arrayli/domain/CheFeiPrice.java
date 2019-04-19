package pers.arrayli.domain; 

/**
 * @author lzj13
 *	车费标准 bean
 */
public class CheFeiPrice {
	private int id;  	// 车费标准id
	private int price;	// 车费标准
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
	@Override
	public String toString() {
		return "CheFei [id=" + id + ", price=" + price + "]";
	}
	
	
}
 