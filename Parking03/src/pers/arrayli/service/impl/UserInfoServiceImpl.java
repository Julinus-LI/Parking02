package pers.arrayli.service.impl;

import java.sql.SQLException;
import java.util.List;

import pers.arrayli.dao.UserInfoDao;
import pers.arrayli.dao.impl.UserInfoDaoImpl;
import pers.arrayli.domain.UserInfo;
import pers.arrayli.service.UserInfoService;

/**
 * @author lzj13
 *	用户信息业务层代码
 */
public class UserInfoServiceImpl implements UserInfoService{
	// 验证普通用户登录
	@Override
	public int login(String username, String password) throws SQLException {
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		return userInfoDao.login(username, password); 
	}

	@Override
	public UserInfo QueryById(int id) throws SQLException {
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		return userInfoDao.QueryById(id);
	}

	@Override
	public boolean update(int id, UserInfo user) throws SQLException {
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		return userInfoDao.update(id, user);
	}

	@Override
	public int QueryMoneyById(int id) throws SQLException {
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		return userInfoDao.QueryMoneyById(id);
	}

	@Override
	public boolean RegisterUser(UserInfo user) throws SQLException {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.RegisterUser(user);
	}

	@Override
	public List<UserInfo> queryAllUserInfos(String queryName) throws SQLException {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.queryAllUserInfos(queryName);
	}

	@Override
	public boolean addUserInfo(UserInfo user) throws SQLException {
		UserInfoDao dao = new UserInfoDaoImpl();		
		return dao.addUserInfo(user);
	}

	@Override
	public boolean UserRecharge(int uid, int money) throws SQLException {
		UserInfoDao dao = new UserInfoDaoImpl();		
		return dao.UserRecharge(uid, money);
	}

	@Override
	public boolean DelUseInfo(int uid) throws SQLException {
		UserInfoDao dao = new UserInfoDaoImpl();		
		return dao.DelUseInfo(uid);
	}

	@Override
	public boolean updateUserMoney(String chepai, int cost) throws SQLException {
		UserInfoDao dao = new UserInfoDaoImpl();	
		return dao.updateUserMoney(chepai, cost);
	}

}
 