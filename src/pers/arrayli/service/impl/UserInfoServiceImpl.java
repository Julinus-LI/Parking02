package pers.arrayli.service.impl;

import java.sql.SQLException;

import pers.arrayli.dao.UserInfoDao;
import pers.arrayli.dao.impl.UserInfoDaoImpl;
import pers.arrayli.service.UserInfoService;

/**
 * @author lzj13
 *	用户信息业务层代码
 */
public class UserInfoServiceImpl implements UserInfoService{
	// 验证普通用户登录
	@Override
	public boolean login(String username, String password) throws SQLException {
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		return userInfoDao.login(username, password); 
	}

}
 