package pers.arrayli.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.arrayli.dao.CheFeiPriceDao;
import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.CheFei;

/**
 * @author lzj13
 *	实现车费接口
 */
public class CheFeiPriceDaoImpl implements CheFeiPriceDao {

	@Override
	public int findFare() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_price";
		CheFei cheFeil = queryRunner.query(sql,new BeanHandler<CheFei>(CheFei.class));	
		return cheFeil.getPrice();
	}

}
 