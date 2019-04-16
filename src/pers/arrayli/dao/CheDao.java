package pers.arrayli.dao;

import java.sql.SQLException;

import pers.arrayli.domain.Che;

/**
 * @author lzj13
 *	定义车的一些数据操作接口
 */
public interface CheDao {
	/**	添加车辆信息
	 * @param che
	 * @return  添加车辆是否成功
	 * @throws SQLException
	 */
	boolean AddChe(Che che) throws SQLException;
	
	/**	按uid来查询车辆信息
	 * @param uid  用户id
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
	
	/** 通过车辆id来修改车辆的信息
	 * @param che
	 * @return
	 * @throws SQLException
	 */
	boolean updateCheById(int id,Che che) throws SQLException;
	
	
	/** 按车辆id来删除车辆信息
	 * @param id  车辆信息 id
	 * @return  返回删除车辆信息成功与否
	 * @throws SQLException
	 */
	boolean delCheById(int id) throws SQLException;
	
}
 