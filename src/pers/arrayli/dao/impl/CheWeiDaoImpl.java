package pers.arrayli.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pers.arrayli.dao.CheWeiDao;
import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.CheWei;

/**
 * @author lzj13 实现车位接口 数据库访问层
 */
public class CheWeiDaoImpl implements CheWeiDao {

	@Override
	public List<CheWei> QueryCheWei(String hao, String quyu) throws SQLException {
		System.out.println("------------------------CheWeiDaoImpl---------------------");
		System.out.println("hao :"+hao);
		System.out.println("quyu: "+quyu);
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from t_chewei where 1=1";
		if(hao != null){
			sql = sql + " and hao like '%" + hao + "%'";				
		}
		if(quyu != null){
			sql = sql + " and quyu like '%" + hao + "%'";
		}
		
		List<CheWei> list = queryRunner.query(sql,new BeanListHandler<CheWei>(CheWei.class));
		System.out.println("list: "+list.toString());
		System.out.println("------------------------CheWeiDaoImpl---------------------");
		return list;
	}

}
