package pers.arrayli.dao;

import java.sql.SQLException;
import java.util.List;

import pers.arrayli.domain.CheWei;

/**
 * @author lzj13
 *	定义车位数据访问层接口
 */
public interface CheWeiDao {

	/**	按车位号查找或者按区域查找，或者按两者条件一起查找
	 * @param hao
	 * @param quyu
	 * @return
	 * @throws SQLException
	 */
	List<CheWei> QueryCheWei(String hao,String quyu) throws SQLException;
	
	/**	在车位信息表中查找车牌号为 hao 有没有停车
	 * @param hao  车牌号
	 * @return	   返回车牌号为 hao 的车辆有没有停车
	 * @throws SQLException
	 */
	boolean isReverse(String hao) throws SQLException;
	
}
