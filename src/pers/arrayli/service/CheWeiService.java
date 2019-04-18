package pers.arrayli.service;

import java.sql.SQLException;
import java.util.List;

import pers.arrayli.domain.CheWei;

/**
 * @author lzj13
 *	定义车位信息的业务层接口
 */
public interface CheWeiService {
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
	
	/** 更新当前车位信息
	 * @param hao		车牌号
	 * @param adate		当前时间和日期
	 * @param id		车位信息 id
	 * @return			更新成功与否
	 * @throws SQLException
	 */
	boolean updateCheWei(String hao,String adate,int id) throws SQLException;
}
 