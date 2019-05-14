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
	
	/**	通过车位 Id 来查找车位信息
	 * @param id	车位 id查询的车位信息
	 * @return		返回
	 * @throws SQLException
	 */
	CheWei findCheWeiById(int id) throws SQLException;
	
	
	/**	通过车位 id来修改车位信息
	 * @param id		车位信息 id
	 * @param cheWei	车位对象
	 * @return			返回修改成功与否
	 * @throws SQLException
	 */
	boolean updateCheWeiById(int id,CheWei cheWei) throws SQLException;
	
	
	/**	通过车位id来删除车位信息
	 * @param id	车位 id
	 * @return		返回删除车位信息成功与否
	 * @throws SQLException
	 */
	boolean DelCheWeiById(int id) throws SQLException;
	
	
	/**	添加车位信息
	 * @param cheWei	车位信息对象	
	 * @return			添加车位信息成功与否
	 * @throws SQLException
	 */
	boolean AddCheWei(CheWei cheWei) throws SQLException;
	
	
	/**根据车位信息上面的车牌号 来查询用户的余额
	 * @param chepai	车牌号
	 * @return			用户的余额
	 * @throws SQLException
	 */
	int GetUserMoney(String chepai) throws SQLException;
	
	/**按车牌号来跟新车位信息
	 * @param chepai	车牌号	
	 * @return			返回停车成功与否
	 * @throws SQLException
	 */
	boolean updateCheWeiByChepai(String chepai) throws SQLException;
	
	/** 根据添加的车位 id 来判断是否存在车位
	 * @param id  车位 id
	 * @return 返回 id 是否存在;存在 false,不存在 true;
	 * @throws SQLException
	 */
	boolean isExistById(int id) throws SQLException;
	
	
	/**添加车位信息
	 * @param cheWei	车位信息对象	
	 * @return		添加成功与否
	 * @throws SQLException
	 */
	boolean AddCheWeiByExcel(CheWei cheWei)throws SQLException;
}
 