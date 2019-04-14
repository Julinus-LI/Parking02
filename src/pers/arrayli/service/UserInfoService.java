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
	 * @return  登录成功与否
	 * @throws SQLException
	 */
	boolean login(String username,String password) throws SQLException;
}
 