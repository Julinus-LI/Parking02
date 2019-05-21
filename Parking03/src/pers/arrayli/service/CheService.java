package pers.arrayli.service;

import java.sql.SQLException;

import pers.arrayli.domain.Che;
import pers.arrayli.domain.UserInfo;

/**
 * @author lzj13
 *  定义了车的业务层操作接口
 */
public interface CheService {
	/**	添加车辆信息
	 * @param che
	 * @return  添加车辆是否成功
	 * @throws SQLException
	 */
	boolean AddChe(Che che) throws SQLException;
	
	/**	按id来查询车辆信息
	 * @param id  用户id
	 * @return  返回查询到的车辆信息
	 * @throws SQLException
	 */
	Che findByUid(int uid) throws SQLException;
	
	
	/**	按id来查询车辆信息
	 * @param id  车辆信息id
	 * @return  返回查询到的车辆信息
	 * @throws SQLException
	 */
	Che findById(int id) throws SQLException;
	
	/** 根据用户的id来更新用户信息
	 * @param id  用户id
	 * @param user  用户信息bean
	 * @return  返回更新成功与否
	 * @throws SQLException
	 */
	boolean updateCheById(int id,Che che) throws SQLException;
	
	/** 按车辆id来删除车辆信息
	 * @param id  车辆信息 id
	 * @return  返回删除车辆信息成功与否
	 * @throws SQLException
	 */
	boolean delCheById(int id) throws SQLException;
	
	
	/**	根据用户 id来查询车牌号
	 * @param uid	用户id
	 * @return		返回车牌号
	 * @throws SQLException
	 */
	String getHaoByUid(int uid) throws SQLException;
	
	/**根据车牌号来查询用户id
	 * @param chepai		车牌号
	 * @return				用户 uid
	 * @throws SQLException
	 */
	int GetUidByHao(String chepai) throws SQLException;
	
	/**根据车辆信息的id来查找 车辆图片的相对路径
	 * @param id	车辆信息 id
	 * @return		车辆图片信息的相对路径
	 * @throws SQLException
	 */
	String getPicPathById(int id) throws SQLException;
	
	/**按用户 uid 来更新车信息，主要是跟新停车类型 
	 * @param uid 用户 id
	 * @param che	车位信息对象
	 * @return	返回更新成功与否
	 * @throws SQLException
	 */
	boolean UpadteByUid(int uid,Che che) throws SQLException;
	
	/**通过车牌来查找到车辆信息
	 * @param chepai	车牌信息
	 * @return		车辆信息对象
	 * @throws SQLException
	 */
	Che getCheByChePai(String chepai) throws SQLException;
}
 