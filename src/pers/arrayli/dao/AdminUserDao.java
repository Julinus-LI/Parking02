package pers.arrayli.dao;

import java.sql.SQLException;
import java.util.List;

import pers.arrayli.domain.AdminUser;
import pers.arrayli.domain.UserInfo;

/**
 * @author lzj13
 *	管理用户 dao 
 *	定义一些管理的数据操作接口
 */
public interface AdminUserDao {
	/**验证管理员登录
	 * @param name  管理员名字
	 * @param password  管理员密码
	 * @return  登录成功与否
	 * @throws SQLException
	 */
	boolean login(String usernam,String password) throws SQLException;

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
 