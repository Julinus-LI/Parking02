package pers.arrayli.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.arrayli.domain.AdminUser;

import pers.arrayli.dao.AdminUserDao;
import pers.arrayli.db.JDBCUtils;

public class AdminUserDaoImpl  implements AdminUserDao{

	@Override
	public boolean login(String username,String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_admin where userName = ? and userPassword = ?";
		AdminUser admin = queryRunner.query(sql,new BeanHandler<AdminUser>(AdminUser.class),username);
		if(admin != null){
			return true;
		}else{
			return false;
		}
	}

}
 