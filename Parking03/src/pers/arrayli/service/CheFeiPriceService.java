package pers.arrayli.service;

import java.sql.SQLException;
import java.util.List;

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
	List<CheFeiPrice> findFare() throws SQLException;
	
	/**通过车费类型来查询车费信息
	 * @param type	车费类型
	 * @return		车费价格对象
	 * @throws SQLException
	 */
	CheFeiPrice findFare(String type) throws SQLException;
	
	/**	设置车费标准
	 * @param  id		车费标准id
	 * @param price		车费标准
	 * @return	设置车费标准成功与否
	 * @throws SQLException
	 */
	boolean setFare(int id,CheFeiPrice price) throws SQLException;
	
	/**	查询车费价格信息对象
	 * @return	返回查询的车费价格信息对象
	 * @throws SQLException
	 */
	CheFeiPrice QueryFare() throws SQLException;
	
	
	/**	通过车费价格 id来设置车费价格标准
	 * @param id		车费价格 id
	 * @return			设置车费价格成功与否
	 * @throws SQLException
	 */
	//boolean setFare(int id) throws SQLException;
}
 