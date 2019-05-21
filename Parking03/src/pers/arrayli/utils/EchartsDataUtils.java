package pers.arrayli.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.ResultSet;

import pers.arrayli.db.JDBCUtils;

/**
 * @author lzj13
 *	给统计图获取数据
 */
public class EchartsDataUtils {
	/**
	 * @return 返回12个月的 费用
	 * @throws SQLException 
	 */
	public static List<Integer> getAllMonsCost() throws SQLException{
		Connection con = JDBCUtils.getConn();
		
		ResultSet rs = null;
		Statement st =  con.createStatement();		
		
		String sql = "SELECT SUM(cost) AS cost FROM t_chefei WHERE jdate LIKE '%-";
		String oldSql = sql;
		List<Integer> list = new ArrayList<Integer>();
		for(int i =1;i<=12;i++){
			oldSql = sql;
			if(i < 10){
				oldSql = oldSql + "0"+String.valueOf(i)+"-%'";		
			}else{
				oldSql = oldSql + String.valueOf(i)+"-%'";
			}
			rs = st.executeQuery(oldSql);
			if(rs.next()){
				int cost = rs.getInt("cost");
				System.out.println(i+" 月\t"+"cost: "+cost);
				list.add(cost);
			}
			System.out.println("oldSql: "+oldSql);
			
		}

		// 释放链接资源
		JDBCUtils.release(con, st, rs);
		return list;
	}
	
	
	/**
	 * @return 12个月中，每个月的停车次数和
	 * @throws SQLException 
	 */
	public static List<Integer> getAllMonsNums() throws SQLException{
		Connection con = JDBCUtils.getConn();
		
		ResultSet rs = null;
		Statement st =  con.createStatement();		
		
		String sql = "SELECT COUNT(*) AS nums FROM t_chefei WHERE jdate LIKE '%-";
		String oldSql = sql;
		List<Integer> list = new ArrayList<Integer>();
		for(int i =1;i<=12;i++){
			oldSql = sql;
			if(i < 10){
				oldSql = oldSql + "0"+String.valueOf(i)+"-%'";		
			}else{
				oldSql = oldSql + String.valueOf(i)+"-%'";
			}
			rs = st.executeQuery(oldSql);
			if(rs.next()){
				int nums = rs.getInt("nums");
				System.out.println(i+" 月\t"+"nums: "+nums);
				list.add(nums);
			}
			System.out.println("oldSql: "+oldSql);
			
		}

		// 释放链接资源
		JDBCUtils.release(con, st, rs);
		return list;
	}
	
	public static List<Integer> getAllCheWeiNums() throws SQLException{
		
		Connection con = JDBCUtils.getConn();
		ResultSet rs = null;
		Statement st =  con.createStatement();		
		List<Integer> list = new ArrayList<Integer>();
		
		String busySql = "SELECT COUNT(*) AS nums FROM t_chewei WHERE chepai IS NOT NULL";
		String freeSql = "SELECT COUNT(*) AS nums FROM t_chewei WHERE chepai IS NULL";
		
		rs = st.executeQuery(busySql);
		if(rs.next()){
			int nums = rs.getInt("nums");
			list.add(nums);
			System.out.println("nums: "+nums);
		}
		
		rs = st.executeQuery(freeSql);
		if(rs.next()){
			int nums = rs.getInt("nums");
			list.add(nums);
			System.out.println("nums: "+nums);
		}
		// 释放资源
		JDBCUtils.release(con, st,rs);
		return list;
	}
	
	
	
	public static void main(String []args) throws SQLException{
		
		List<Integer> listCost = getAllMonsCost();
		for(Integer t:listCost){
			System.out.println("t: "+t);
		}
		
		List<Integer> listNums = getAllMonsNums();
		for(Integer tt:listCost){
			System.out.println("tt: "+tt);
		}
		
		List<Integer> listCheWeiNums = getAllCheWeiNums();
		int busyNums = listCheWeiNums.get(0);
		int freeNums = listCheWeiNums.get(1);
		
		System.out.println("busyNums: "+busyNums+"\tfreeNums: "+freeNums);
	}
}
