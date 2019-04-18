package pers.arrayli.service;

import java.sql.SQLException;
import java.util.List;

import pers.arrayli.domain.AdminUser;

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
	

	/**	查询所有管理员用户
	 * @return	所有管理员用户的集合
	 * @throws SQLException	
	 */
	List<AdminUser> queryAdmins() throws SQLException;
	
	/**通过 id 对管理员表进行查询
	 * @param id 管理员id
	 * @return	返回管理员信息
	 * @throws SQLException
	 */
	AdminUser findAdminById(int id) throws SQLException;
}
