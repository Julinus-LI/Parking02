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
	public boolean login(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_userinfo  where username = ? and pwd = ?";
		UserInfo userinfo = queryRunner.query(sql,new BeanHandler<UserInfo>(UserInfo.class),username,password);
		if(userinfo != null){
			return true;
		}else{
			return false;
		}
	}

}
 