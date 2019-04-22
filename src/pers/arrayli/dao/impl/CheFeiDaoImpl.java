package pers.arrayli.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import pers.arrayli.dao.CheFeiDao;
import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.CheFei;

/**
 * @author lzj13
 *	车费信息实现类
 */
public class CheFeiDaoImpl implements CheFeiDao{

	@Override
	public boolean AddCheFei(CheFei cheFei) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into t_chefei values(null,?,?,?,?,?,?,?)";
		
		int result = queryRunner.update(sql,cheFei.getHao(),cheFei.getJdate(),cheFei.getLdate(),
				cheFei.getCost(),cheFei.getAdate(),cheFei.getHours(),cheFei.getPrice());
		
		return result > 0;
	}

}
 