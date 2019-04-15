package pers.arrayli.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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

}
 