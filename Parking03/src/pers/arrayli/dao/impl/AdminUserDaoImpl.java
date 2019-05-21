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
	public List<AdminUser> queryAdmins(String  queryName) throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_admin";
		if(queryName != null){
			sql = "select* from t_admin where userName like '%"+queryName+"%'";
		}
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

	@Override
	public boolean updateAdminById(int id,AdminUser admin) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_admin set userName = ?,userPassword = ? where id = ?";
		int result = queryRunner.update(sql,admin.getUserName(),admin.getUserPassword(),id);
		return result > 0;
	}

	@Override
	public boolean delAdminById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from t_admin where id = ?";
		int result = queryRunner.update(sql,id);
		return result > 0;
	}

	@Override
	public boolean addAdmin(AdminUser admin) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into t_admin values(null,?,?) ";
		int result = queryRunner.update(sql,admin.getUserName(),admin.getUserPassword());
		return result > 0;
	}

}
 