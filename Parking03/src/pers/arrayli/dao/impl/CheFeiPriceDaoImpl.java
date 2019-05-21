package pers.arrayli.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pers.arrayli.dao.CheFeiPriceDao;
import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.CheFeiPrice;

/**
 * @author lzj13
 *	实现车费接口
 */
public class CheFeiPriceDaoImpl implements CheFeiPriceDao {

	@Override
	public List<CheFeiPrice> findFare() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_price";
		List<CheFeiPrice> list = queryRunner.query(sql,new BeanListHandler<CheFeiPrice>(CheFeiPrice.class));	
		return list;
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

	@Override
	public CheFeiPrice findFare(String type) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_price where type = ?";
		CheFeiPrice cheFeiPrice = queryRunner.query(sql,new BeanHandler<CheFeiPrice>(CheFeiPrice.class),type);
		return cheFeiPrice;
	}

}
 