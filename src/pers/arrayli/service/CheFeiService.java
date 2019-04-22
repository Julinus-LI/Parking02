package pers.arrayli.service;

import java.sql.SQLException;

import pers.arrayli.domain.CheFei;

/**
 * @author lzj13
 *	车费业务层接口
 */
public interface CheFeiService {
	/**添加车费信息
	 * @param cheFei  车费信息对象
	 * @return	添加成功与否
	 * @throws SQLException
	 */
	boolean AddCheFei(CheFei cheFei) throws SQLException;
}
 