package pers.arrayli.service;

import java.sql.SQLException;

import pers.arrayli.domain.CheFeiPrice;

/**
 * @author lzj13
 *	定义车费标准业务层接口
 */
public interface CheFeiPriceService {
	/**	查询车费标准
	 * @return 查询的车费标准
	 * @throws SQLException
	 */
	int findFare() throws SQLException;
	
	/**	设置车费标准
	 * @param  id		车费标准id
	 * @param price		车费标准
	 * @return	设置车费标准成功与否
	 * @throws SQLException
	 */
	boolean setFare(int id,CheFeiPrice price) throws SQLException;
}
 