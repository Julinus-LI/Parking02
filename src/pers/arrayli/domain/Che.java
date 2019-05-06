package pers.arrayli.domain; 

public class Che {
	private int id;				// 车辆信息id
	private String hao;			// 车牌号
	private String leixing;		// 车类型
	private String picture;		// 图片
	private String info;		// 备注
	private int uid;			// 用户id
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
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Che [id=" + id + ", hao=" + hao + ", leixing=" + leixing + ", picture=" + picture + ", info=" + info
				+ ", uid=" + uid + "]";
	}
	
	
}
 