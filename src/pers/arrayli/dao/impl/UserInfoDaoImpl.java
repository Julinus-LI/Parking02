package pers.arrayli.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pers.arrayli.domain.AdminUser;
import pers.arrayli.domain.UserInfo;

import pers.arrayli.dao.UserInfoDao;
import pers.arrayli.db.JDBCUtils;
/**
 * @author lzj13
 *	实现用户信息数据访问层
 */
public class UserInfoDaoImpl implements UserInfoDao{

	@Override
	public int login(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_userinfo  where username = ? and pwd = ?";
		UserInfo userinfo = queryRunner.query(sql,new BeanHandler<UserInfo>(UserInfo.class),username,password);
		if(userinfo != null){
			return userinfo.getId();
		}else{
			return 0;
		}
	}

	@Override
	public UserInfo QueryById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_userinfo where id = ?";
		UserInfo userinfo = queryRunner.query(sql,new BeanHandler<UserInfo>(UserInfo.class),id);
		return userinfo;
	}

	@Override
	public boolean update(int id, UserInfo user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_userinfo set username = ?,pwd = ?,age = ?,tel = ? where id = ?";
		int res = queryRunner.update(sql,user.getUsername(),user.getPwd(),user.getAge(),user.getTel(),id);
		System.out.println("更新用户 uid = "+id+" 的信息，返回值为 res= "+res);
		return res>0;
	}

	@Override
	public int QueryMoneyById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select money from t_userinfo where id = ?";
		UserInfo user = queryRunner.query(sql,new BeanHandler<UserInfo>(UserInfo.class),id);
		return user.getMoney();
	}

	@Override
	public boolean RegisterUser(UserInfo user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into t_userinfo values(null,?,?,?,?,?)";
		int result = queryRunner.update(sql,user.getUsername(),user.getPwd(),user.getAge(),user.getTel(),user.getMoney());	
		return result > 0;
	}

	@Override
	public List<UserInfo> queryAllUserInfos(String queryName) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_userinfo";
		if(queryName != null){
			sql = "select* from t_userinfo where username like '%"+queryName+"%'";
		}
		List<UserInfo> list = queryRunner.query(sql, new BeanListHandler<UserInfo>(UserInfo.class));
		return list;
	}

	@Override
	public boolean addUserInfo(UserInfo user) throws SQLException {
		return new UserInfoDaoImpl().RegisterUser(user);
	}

	@Override
	public boolean UserRecharge(int uid, int money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_userinfo set money = money + ? where id = ?";	
		int result = queryRunner.update(sql,money,uid);	
		return result > 0;
	}

	@Override
	public boolean DelUseInfo(int uid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from t_userinfo where id = ?";
		int result = queryRunner.update(sql,uid);
		return result>0;
	}

	@Override
	public boolean updateUserMoney(String chepai, int cost) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_userinfo set money = money - ? where "
				+ "id = (select uid from t_che where hao = ?) ";
		// UPDATE t_userinfo SET money = money -100 WHERE id = (SELECT uid FROM t_che WHERE hao = '001');
		int resutl = queryRunner.update(sql,cost,chepai);
		return resutl > 0;
	}

}
 