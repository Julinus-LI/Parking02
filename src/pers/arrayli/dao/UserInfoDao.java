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
	
	/**  按用户信息进行查询，把用户信息显示出来
	 * @param id
	 * @return  返回用户信息bean
	 * @throws SQLException
	 */
	UserInfo QueryById (int id) throws SQLException;

	/** 根据用户的id来更新用户信息
	 * @param id  用户id
	 * @param user  用户信息bean
	 * @return  返回更新成功与否
	 * @throws SQLException
	 */
	boolean update(int id,UserInfo user) throws SQLException;
	
}
 