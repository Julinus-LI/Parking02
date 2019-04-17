package pers.arrayli.service;

import java.sql.SQLException;

/**
 * @author lzj13
 *	定义车费标准业务层接口
 */
public interface CheFeiService {
	/**	查询车费标准
	 * @return 查询的车费标准
	 * @throws SQLException
	 */
	int findFare() throws SQLException;
}
 