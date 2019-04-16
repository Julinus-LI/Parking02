package pers.arrayli.domain; 

public class Che {
	private int id;
	private String hao;
	private String leixing;
	private String picutrePath;
	private String info;
	private int uid;
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
	public String getPicutrePath() {
		return picutrePath;
	}
	public void setPicutrePath(String picutrePath) {
		this.picutrePath = picutrePath;
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
		return "Che [id=" + id + ", hao=" + hao + ", leixing=" + leixing + ", picutrePath=" + picutrePath + ", info="
				+ info + ", uid=" + uid + "]";
	}
}
 