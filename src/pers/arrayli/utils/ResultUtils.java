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

public class ResultUtils {
	public static List<CheFei> list = null;
	public static final int pageSize = 7; 
	
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
}
