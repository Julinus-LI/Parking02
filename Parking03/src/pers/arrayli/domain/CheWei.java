package pers.arrayli.domain; 

/**
 * @author lzj13
 *	车位bean
 */
public class CheWei {
	private int id;				// 车位 id
	private String hao;			// 车位号
	private String info;		// 备注
	private String quyu;		// 区域
	private String chepai;		// 车牌	
	private String adate;
	
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getQuyu() {
		return quyu;
	}
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	public String getChepai() {
		return chepai;
	}
	public void setChepai(String chepai) {
		this.chepai = chepai;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "CheWei [id=" + id + ", hao=" + hao + ", info=" + info + ", quyu=" + quyu + ", chepai=" + chepai
				+ ", adate=" + adate + "]";
	}	
	
}
 