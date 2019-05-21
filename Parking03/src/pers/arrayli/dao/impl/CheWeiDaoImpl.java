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
import pers.arrayli.domain.UserInfo;

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
		System.out.println("---------------------  isReverse DEBUG Starts --------------------");
		String sql  = "select * from t_chewei where chepai = ?";
		System.out.println("hao : "+hao);
		System.out.println("sql: "+sql);
		CheWei cheWei = queryRunner.query(sql,new BeanHandler<CheWei>(CheWei.class) ,hao);
		System.out.println("cheWei: "+cheWei);
		System.out.println("---------------------  isReverse DEBUG End --------------------");
		// 如果车牌号为 hao的车，查询的车位号不为空，说明该车已经停车
		if(cheWei != null){
			return true;
		}
		// 为空的话，说明该车还没有停车
		return false;
	}

	@Override
	public boolean updateCheWei(String hao, String adate, int id) throws SQLException {
		System.out.println("================== updateCheWei DEBUG Start =============");
		System.out.println("hao: "+hao+"  adate: "+adate+" id: "+id);
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_chewei set chepai = ?,adate = ? where id = ?";
		int result = queryRunner.update(sql,hao,adate,id);
		System.out.println("================== updateCheWei DEBUG End =============");
		return result > 0;
	}

	@Override
	public CheWei findCheWeiById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_chewei where id = ?";
		CheWei cheWei = queryRunner.query(sql,new BeanHandler<CheWei>(CheWei.class) ,id);
		return cheWei;
	}

	@Override
	public boolean updateCheWeiById(int id, CheWei cheWei) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_chewei set hao = ?,quyu = ?,info = ? where id = ?";	
		int result = queryRunner.update(sql,cheWei.getHao(),cheWei.getQuyu(),cheWei.getInfo(),id);
		return result > 0;
	}

	@Override
	public boolean DelCheWeiById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from t_chewei where id = ?";
		int result = queryRunner.update(sql,id);
		return result > 0;
	}

	@Override
	public boolean AddCheWei(CheWei cheWei) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into t_chewei values(null,?,?,?,?,?)";
		int result = queryRunner.update(sql,cheWei.getHao(),cheWei.getInfo(),cheWei.getQuyu(),
				cheWei.getChepai(),cheWei.getAdate());
		
		return result > 0;
	}

	@Override
	public int GetUserMoney(String chepai) throws SQLException {
		System.out.println("--------------- CheWeiDaoImpl GetUserMoney Debug Start ------------ ");
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from t_userinfo a,t_che b,t_chewei c"
				+ " where a.id = b.uid and b.hao = c.chepai and c.chepai = ?";
		System.out.println("chepai: "+chepai);
		System.out.println("============================1=======================");
		//String sql = "select * t_userinfo where id = (select uid from t_che where chepai = '沪BHJ521')";
		//sql = "select * t_userinfo where id = '?'";
		System.out.println("============================2=======================");
		System.out.println("sql: "+sql);
		UserInfo user = queryRunner.query(sql,new BeanHandler<UserInfo>(UserInfo.class) ,chepai);
		//UserInfo user = queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class),chepai);
		
		System.out.println("GetUserMoney user: "+user.toString());
		int balance = 0;    // 余额
		System.out.println("============================3=======================");
		if(user != null){
			balance = user.getMoney();
		}
		System.out.println("banlance : "+balance);
		System.out.println("--------------- CheWeiDaoImpl GetUserMoney Debug Start ------------ ");
		return balance;
	}

	@Override
	public boolean updateCheWeiByChepai(String chepai) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_chewei set chepai = ?,adate = ? where chepai = ?";
		int result = queryRunner.update(sql,"","",chepai);
		return result > 0;
	}

	@Override
	public boolean isExistById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from t_chewei where id = ?";
		CheWei chewei = queryRunner.query(sql,new BeanHandler<CheWei>(CheWei.class) ,id);
		if(chewei != null){
			return true;
		}
		return false;
	}

	@Override
	public boolean AddCheWeiByExcel(CheWei cheWei) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = null;
		int result = 0;
		if(isExistById(cheWei.getId())){
			sql = "insert into t_chewei values(null,?,?,?,?,?)";
			 result = queryRunner.update(sql,cheWei.getHao(),cheWei.getInfo(),cheWei.getQuyu(),
						cheWei.getChepai(),cheWei.getAdate());
		}else{
			sql = "insert into t_chewei values(?,?,?,?,?,?)";
			 result = queryRunner.update(sql,cheWei.getId(),cheWei.getHao(),cheWei.getInfo(),cheWei.getQuyu(),
						cheWei.getChepai(),cheWei.getAdate());
		}
			
		return result > 0;
	}

}
