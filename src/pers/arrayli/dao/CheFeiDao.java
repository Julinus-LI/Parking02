package pers.arrayli.dao;

import java.sql.SQLException;

import pers.arrayli.domain.CheFei;

/**
 * @author lzj13
 *	车费信息接口		主要定义关于车费的操作
 */
public interface CheFeiDao {
	/**添加车费信息
	 * @param cheFei  车费信息对象
	 * @return	添加成功与否
	 * @throws SQLException
	 */
	boolean AddCheFei(CheFei cheFei) throws SQLException;
}
 