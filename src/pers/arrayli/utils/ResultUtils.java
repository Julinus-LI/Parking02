package pers.arrayli.utils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.CheFei;
import pers.arrayli.domain.CheWei;
import pers.arrayli.domain.PageBean;

/**
 * @author lzj13
 *	获取数据结果集
 */
public class ResultUtils {
	public static List<CheFei> list = null;			// 车费信息集合
	public static List<CheWei> listCheWei = null;	// 车位信息集合
	public static final int pageSize = 7; 			// 每页显示的数据个数
	
	/**按车位号和区域号
	 * @param hao  车位号
	 * @param quyu	区域号
	 */
	public void getCheWei(String hao,String quyu){
		// 2.连接数据库进行模糊查询
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_chewei where 1=1";
		if (hao != null) {
			sql = sql + " and hao like '%" + hao + "%'";
		}
		if(quyu != null){
			sql  = sql + "and quyu like '%" + quyu + "%'";
		}
		System.out.println("sql: " + sql);
		
		List<CheWei> list1 = null;
		
		try {
			list1 = queryRunner.query(sql, new BeanListHandler<CheWei>(CheWei.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("===========================打印模糊查询结果=================");
		System.out.println("总共有 " + list1.size() + "个记录");
		for (CheWei chewei : list1) {
			System.out.println(chewei.toString());
		}
		System.out.println("===========================打印模糊查询结果=================");
		System.out.println("==========================listCheWei===============");
		
		listCheWei = list1;
		for(CheWei chewei:listCheWei){
			System.out.println(chewei.toString());
		}
		
		System.out.println("==========================listCheWei===============");
	}
	
	
	/**
	 * @param currentPage	当前页数
	 * @param hao			车位号
	 * @param quyu			区域
	 * @return				车位信息集合
	 */
	public List<CheWei> PageListQueryCheWei(int currentPage, String hao, String quyu){
		CheWei [] tempList = new CheWei[listCheWei.size()];			
		List<CheWei> temp = new ArrayList<CheWei>();
		Iterator<CheWei> iterator = listCheWei.iterator();
		
		
		for(int i=0;i<listCheWei.size();i++){
			if(iterator.hasNext()){
				tempList[i] = iterator.next();
			}
		}
		
		
		if(tempList != null){
			
			System.out.println("===================打印arrayList=================");
			
			for(int i=0;i<tempList.length;i++){
				System.out.println(tempList[i]);
			}
			
			System.out.println("===================打印arrayList=================");
			
			// 2.判断是否是第一页，第一页的话，从 tempList 中获取个元素
			if(currentPage == 1){
				for(int i=0;(i<pageSize) && (i<tempList.length);i++){
					temp.add(tempList[i]);
				}
			}else{
				int j = 0;
				// 遍历过 currentPage*pageSize 个元素
				for(int i = (currentPage-1)*pageSize;(j<pageSize) && (i<tempList.length);i++ ){
					temp.add(tempList[i]);
					j++;
				}
			}
			
		}

		System.out.println("temp: "+temp.toString());
		return temp;
		
	}
	
	
	/**按照车牌号和入场时间来查询车费信息结果集
	 * @param hao	车牌号
	 * @param jdate 入场时间
	 */
	public void query(String hao, String jdate) {
		// 2.连接数据库进行模糊查询
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

		String sql = "select* from t_chefei where 1=1";
		if (hao != null) {
			sql = sql + " and hao like '%" + hao + "%'";
		}
		System.out.println("sql: " + sql);
		if (jdate != null) {
			sql = sql + " and jdate like '%" + jdate + "%'";
		}
		System.out.println("sql: " + sql);

		List<CheFei> list1 = null;
		try {
			list1 = queryRunner.query(sql, new BeanListHandler<CheFei>(CheFei.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("===========================打印模糊查询结果=================");
		System.out.println("总共有 " + list1.size() + "个记录");
		for (CheFei cheFei : list1) {
			System.out.println(cheFei.toString());
		}
		System.out.println("===========================打印模糊查询结果=================");
		
		list = list1;
	}
	
	/**根据当前页数，车牌号，入场时间来返回车费信息集合
	 * @param currentPage	当前页数
	 * @param hao			车牌号
	 * @param jdate			入场时间
	 * @return	返回车费信息集合
	 */
	public List<CheFei> PageListQuery(int currentPage, String hao, String jdate){
		
		//ArrayList<CheFei> arrayList = new ArrayList<CheFei>();
		CheFei [] tempList = new CheFei[list.size()];			
		List<CheFei> temp = new ArrayList<CheFei>();
		Iterator<CheFei> iterator = list.iterator();
		
		
		for(int i=0;i<list.size();i++){
			if(iterator.hasNext()){
				tempList[i] = iterator.next();
			}
		}
		
		
		if(tempList != null){
			
			System.out.println("===================打印arrayList=================");
			
			for(int i=0;i<tempList.length;i++){
				System.out.println(tempList[i]);
			}
			
			System.out.println("===================打印arrayList=================");
			
			// 2.判断是否是第一页，第一页的话，从 tempList 中获取个元素
			if(currentPage == 1){
				for(int i=0;(i<pageSize) && (i<tempList.length);i++){
					temp.add(tempList[i]);
				}
			}else{
				int j = 0;
				// 遍历过 currentPage*pageSize 个元素
				for(int i = (currentPage-1)*pageSize;(j<pageSize) && (i<tempList.length);i++ ){
					temp.add(tempList[i]);
					j++;
				}
			}
			
		}
		
		System.out.println("temp: "+temp.toString());
		return temp;
	}

//=============================================车位分页信息=========================
			public  int getCheWeiTotalSize(){
				System.out.println("getCheWeiTotalSize(): "+listCheWei.size());
				return  listCheWei.size();
			}
			
			public int getCheWeiPageSize(){
				System.out.println("getCheWeiPageSize(): "+pageSize);
				return pageSize;
			}
			
			public int  getCheWeiTotalPage(){
				System.out.println("getCheWeiTotalPage(): "+listCheWei.size());
				int temp = listCheWei.size() % pageSize;
				if(temp != 0){
					temp = listCheWei.size() / pageSize + 1;
				}else{
					temp = listCheWei.size() / pageSize;
				}
				return temp;
			}
//=============================================车位分页信息=========================	
	
//=============================================车费分页信息=========================
	public  int getTotalSize(){
		return list.size();
	}
	
	public int getPageSize(){
		return pageSize;
	}
	
	public int  getTotalPage(){
		int temp = list.size() % pageSize;
		if(temp != 0){
			temp = list.size() / pageSize + 1;
		}
		return temp;
	}
//=============================================车费分页信息=========================
}
