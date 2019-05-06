package pers.arrayli.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.arrayli.dao.CheFeiPriceDao;
import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.CheFeiPrice;

/**
 * @author lzj13
 *	实现车费接口
 */
public class CheFeiPriceDaoImpl implements CheFeiPriceDao {

	@Override
	public int findFare() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_price";
		CheFeiPrice cheFeil = queryRunner.query(sql,new BeanHandler<CheFeiPrice>(CheFeiPrice.class));	
		return cheFeil.getPrice();
	}

	@Override
	public boolean setFare(int id,CheFeiPrice price) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_price set price = ? where id = ?";
		int result = queryRunner.update(sql,price.getPrice(),id);
		return result > 0;
	}

	@Override
	public CheFeiPrice QueryFare() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_price";
		CheFeiPrice cheFeil = queryRunner.query(sql,new BeanHandler<CheFeiPrice>(CheFeiPrice.class));	
		return cheFeil;
	}

}
 