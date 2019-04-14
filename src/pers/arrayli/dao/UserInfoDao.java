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
	 * @return  成功：返回用户的id；失败：0
	 * @throws SQLException
	 */
	int login(String username,String password) throws SQLException;
}
 