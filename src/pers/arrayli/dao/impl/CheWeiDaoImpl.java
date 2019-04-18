package pers.arrayli.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pers.arrayli.dao.CheWeiDao;
import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.Che;
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
			sql = sql + " and quyu like '%" + quyu + "%'";
		}
		
		System.out.println("sql: "+sql);
		List<CheWei> list = queryRunner.query(sql,new BeanListHandler<CheWei>(CheWei.class));
		System.out.println("list: "+list.toString());
		System.out.println("------------------------CheWeiDaoImpl---------------------");
		return list;
	}

	@Override
	public boolean isReverse(String hao) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql  = "select chepai from t_chewei where hao = ?";
		CheWei cheWei = queryRunner.query(sql,new BeanHandler<CheWei>(CheWei.class) ,hao);
		// 如果车牌号为 hao的车，查询的车位号不为空，说明该车以及停车
		if(cheWei.getHao() != null){
			return true;
		}
		// 为空的话，说明该车还没有停车
		return false;
	}

}
