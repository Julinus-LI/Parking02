package pers.arrayli.domain; 

/**
 * @author lzj13
 *	车费bean
 */
public class CheFei {
	private int id;			// 车费信息 id
	private String hao;		// 车牌号
	private String jdate;	// 入场时间	
	private String ldate;	// 离开时间
	private int cost;		// 费用
	private String adate;	// 当前时间
	private int hours;		// 停车时长
	private int price;		// 停车价格标准
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHao() {
		return hao;
	}
	public void setHao(String hao) {
		this.hao = hao;
	}
	public String getJdate() {
		return jdate;
	}
	public void setJdate(String jdate) {
		this.jdate = jdate;
	}
	public String getLdate() {
		return ldate;
	}
	public void setLdate(String ldate) {
		this.ldate = ldate;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CheFei [id=" + id + ", hao=" + hao + ", jdate=" + jdate + ", ldate=" + ldate + ", cost=" + cost
				+ ", adate=" + adate + ", hours=" + hours + ", price=" + price + "]";
	}
}
 