package pers.arrayli.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pers.arrayli.domain.AdminUser;

import pers.arrayli.dao.AdminUserDao;
import pers.arrayli.db.JDBCUtils;

/**
 * @author lzj13
 *	实现管理员用户接口   数据访问层
 */
public class AdminUserDaoImpl  implements AdminUserDao{

	@Override
	public boolean login(String username,String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_admin where userName = ? and userPassword = ?";
		AdminUser admin = queryRunner.query(sql,new BeanHandler<AdminUser>(AdminUser.class),username,password);
		if(admin != null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<AdminUser> queryAdmins() throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_admin";
		List<AdminUser>list  = queryRunner.query(sql,new BeanListHandler<AdminUser>(AdminUser.class));
		return list;
	}

	@Override
	public AdminUser findAdminById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_admin where id = ?";
		AdminUser admin = queryRunner.query(sql,new BeanHandler<AdminUser>(AdminUser.class),id);
		return admin;
	}

}
 