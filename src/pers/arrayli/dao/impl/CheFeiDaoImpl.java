package pers.arrayli.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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

	@Override
	public List<CheFei> QueryCheFei(String chepai, String date) throws SQLException {
		System.out.println("--------------------- CheFeiDaoImpl QueryCheFei --------------------");
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from t_chefei where 1=1";
		if(chepai != null){
			//sql = sql + " and  hao like '%" + queryName + "%'";
			sql = sql + " and hao like '%" + chepai + "%'";
		}
		if(date != null){
			// sql = sql + " and  jdate like '%" + queryName2 + "%'";
			sql  = sql + " and jdate like '%" + date + "%'";
		}
		List<CheFei> list = queryRunner.query(sql,new BeanListHandler<CheFei>(CheFei.class));
		System.out.println("sql: "+sql);
		System.out.println("list: "+list);
		System.out.println("--------------------- CheFeiDaoImpl QueryCheFei --------------------");
		return list;
	}

	@Override
	public List<CheFei> findCheFeiByPage(int currentPage,String chepai,String jdate) throws SQLException {
		QueryRunner  queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		// String sql = "select* from t_chefei limit ? offset ?";
		System.out.println("chepai: "+chepai+"\tjdate: "+jdate);
		String sql = "select* from t_chefei where 1=1";
		if(chepai != null){
			sql = sql + " and hao like '%" + chepai+"%'";
		}
		if(jdate != null){
			sql = sql + " and jdate like '%" + jdate+"%'";
		}
		
		sql  = sql + " limit ? offset ?";
		System.out.println("sql : " +sql);
		return queryRunner.query(sql,new BeanListHandler<CheFei>(CheFei.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
	}

	@Override
	public int findCount(String chepai,String jdate) throws SQLException {
		System.out.println("--------------- findCount Debug Start -----------------");
		QueryRunner  queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_chefei";
		List<CheFei> list = queryRunner.query(sql, new BeanListHandler<CheFei>(CheFei.class));
		int result = 0;
		System.out.println("res: "+list.size());
		System.out.println("--------------- findCount Debug End -----------------");
		
		if(list != null){
			result	= list.size();
		}else{
			result = 0;
		}
		return list.size();
	}

}
 