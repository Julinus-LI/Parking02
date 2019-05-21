package pers.arrayli.dao;

import java.sql.SQLException;
import java.util.List;

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
	
	/**	根据用户的 id来 查询用户的余额
	 * @param id		
	 * @return  用户余额
	 * @throws SQLException
	 */
	int QueryMoneyById(int id) throws SQLException;
	
	
	/**注册用户
	 * @param user	户信息对象
	 * @return		返回是否注册成功
	 * @throws SQLException
	 */
	boolean RegisterUser(UserInfo user) throws SQLException;
	
	/**	查询所有的用户信息或者按条件进行查询用户信息
	 * @param queryName   查询条件
	 * @return	查询结果集
	 * @throws SQLException
	 */
	List<UserInfo> queryAllUserInfos(String queryName) throws SQLException;
	
	
	/**添加用户信息
	 * @param user	添加的用户信息
	 * @return		添加成功与否
	 * @throws SQLException
	 */
	boolean addUserInfo(UserInfo user) throws SQLException;
	
	
	/**	按用户 id来对用户进行充值
	 * @param uid   用户 id
	 * @param money   充值金额
	 * @return	返回充值成功与否
	 * @throws SQLException
	 */
	boolean UserRecharge(int uid,int money) throws SQLException;
	
	/**按用户 id来删除用户
	 * @param uid	用户id
	 * @return		返回删除成功与否
	 * @throws SQLException
	 */
	boolean DelUseInfo(int uid) throws SQLException;
	
	/**根据用户的车牌号来更新用户卡上的余额
	 * @param chepai		车牌号
	 * @param cost			停车费用
	 * @return				返回更新成功与否
	 * @throws SQLException
	 */
	boolean updateUserMoney(String chepai,int cost) throws SQLException;
	
}
 