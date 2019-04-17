package pers.arrayli.dao;

import java.sql.SQLException;

/**
 * @author lzj13
 *	车费标准接口
 *	主要用来定义一些设置和查询车费标准的接口
 */
public interface CheFeiDao {
	/**	查询车费标准
	 * @return 查询的车费标准
	 * @throws SQLException
	 */
	int findFare() throws SQLException;
}
 