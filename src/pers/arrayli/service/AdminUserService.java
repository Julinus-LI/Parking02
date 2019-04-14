package pers.arrayli.service;

import java.sql.SQLException;

/**
 * @author lzj13
 *	定义管理员用户操作的业务逻辑层接口
 */
public interface AdminUserService {
	/**验证管理员登录
	 * @param name  管理员名字
	 * @param password  管理员密码
	 * @return  登录成功与否
	 * @throws SQLException
	 */
	boolean login(String username,String password) throws SQLException;
}
