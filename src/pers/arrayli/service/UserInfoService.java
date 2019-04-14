package pers.arrayli.service;

import java.sql.SQLException;

/**
 * @author lzj13
 *	用户信息业务层接口
 */
public interface UserInfoService {
	/**验证普通用户登录
	 * @param name  普通用户名字
	 * @param password  普通用户密码
	 * @return  成功：返回用户的id；失败：0
	 * @throws SQLException
	 */
	int login(String username,String password) throws SQLException;
}
 