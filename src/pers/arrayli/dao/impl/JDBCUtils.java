package pers.arrayli.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.xml.internal.ws.Closeable;

/**
 * @author lzj13
 *	进行数据库的连接和释放操作    这里使用C3P0数据库连来获取数据源和创建数据库连接
 */
public class JDBCUtils {
	// 定义数据源变量
	static ComboPooledDataSource dataSource = null;
	
	//使用静态加载数据源，在代码一加载就获取到数据
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	/**
	 * @return  返回数据数据源
	 */
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	
	
	/**
	 * @return  返回创建的数据库连接对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/** 这个方法用于释放数据库的数据的查询连接
	 * @param con  数据库连接对象
	 * @param st   执行不带参数的sql语句
	 * @param rs   数据结果集合
	 */
	public void release(Connection con,Statement st,ResultSet rs){
		closeCon(con);
		closeSt(st);
		closeRs(rs);
	}
	
	/** 重载释放连接方法 这个方法用于数据库增，删，改等功能
	 * @param con  数据库连接对象
	 * @param st   执行不带参数的sql语句
	 * @param rs   数据结果集合
	 */
	public void release(Connection con,Statement st){
		closeCon(con);
		closeSt(st);
	}
	
	/** 关闭数据库连接对象
	 * @param con  数据库连接对象
	 * @throws SQLException 
	 */
	public void closeCon(Connection con) {
		try {
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con = null;
		}
	}
	
	/** 关闭数据库操作语句对象
	 * @param st  数据库语句执行对象
	 */
	public void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			st = null;
		}
	}
	
	/** 关闭数据库查询结果街
	 * @param st  查询结果集
	 */
	public void closeRs(ResultSet rSet){
		try {
			if(rSet != null){
				rSet.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			rSet = null;
		}
	}
}
 