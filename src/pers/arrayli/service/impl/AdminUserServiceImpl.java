package pers.arrayli.service.impl;

import java.sql.SQLException;

import pers.arrayli.domain.AdminUser;

import pers.arrayli.dao.AdminUserDao;
import pers.arrayli.dao.impl.AdminUserDaoImpl;
import pers.arrayli.service.AdminUserService;

/**
 * @author lzj13
 *	实现AdminUserService接口的方法
 */
public class AdminUserServiceImpl implements AdminUserService {

	@Override
	public boolean login(String username,String password) throws SQLException {
		AdminUserDao dao = new AdminUserDaoImpl();
		return dao.login(username,password);
	}
}
 