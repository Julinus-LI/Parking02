package pers.arrayli.dao;

import java.sql.SQLException;

import pers.arrayli.domain.UserInfo;

/**
 * @author lzj13
 * 普通用户 dao  用户信息数据访问层
 */
public interface UserInfoDao {
	/**验证普通用户登录
	 * @param name  普通用户名字
	 * @param password  普通用户密码
	 * @return  登录成功与否
	 * @throws SQLException
	 */
	boolean login(String username,String password) throws SQLException;
}
 