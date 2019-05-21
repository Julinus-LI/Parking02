package pers.arrayli.utils;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpUtils;

import jxl.Sheet;
import jxl.Workbook;
import pers.arrayli.domain.CheWei;
import pers.arrayli.service.CheWeiService;
import pers.arrayli.service.impl.CheWeiServiceImpl;

/**
 * @author lzj13
 *	工具类：把excel中的数据导入到数据库中
 */
public class ImportExcel {
    
    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return  返回表格中的数据集合 list
     */
    public static List<CheWei> getAllByExcel(String file){
    	System.out.println("======================getAllByExcel======================");
    	System.out.println("file: "+file);
    	List<CheWei> list=new ArrayList<CheWei>();
    	
   
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String id = rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String hao = rs.getCell(j++, i).getContents();
                    String info = rs.getCell(j++, i).getContents();
                    String quyu = rs.getCell(j++, i).getContents();
                    String chepai = rs.getCell(j++, i).getContents();
                    String adate = rs.getCell(j++, i).getContents();
                    
                    CheWei cheWei = new CheWei();
                    cheWei.setId(Integer.parseInt(id));
                    cheWei.setHao(hao);
                    cheWei.setInfo(info);
                    cheWei.setQuyu(quyu);
                 /*   cheWei.setChepai("NULL");
                    cheWei.setAdate("NULL");*/
                    cheWei.setChepai(null);
                    cheWei.setAdate(null);
                    
                    System.out.println(cheWei.toString());
                    list.add(cheWei);
                    
                   /* System.out.println("id:"+id+" name:"+name+" sex:"+sex+" num:"+num);
                    list.add(new StuEntity(Integer.parseInt(id), name, sex, Integer.parseInt(num)));*/
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        System.out.println("======================getAllByExcel======================");
        return list;
        
    }
    
    /**
     * 通过Id判断是否存在
     * @param id  车位信息id 
     * @return 当前插入的数据的id是否存在 ，存在 false 不存在 true
     */
    public static boolean isExist(int id){

		try {
			CheWeiService service = new CheWeiServiceImpl();
			boolean result = service.isExistById(id);
			if(result){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    	
		}
		return false;
    }
	
	public static void ImportExcel(String filePath){
		
		 // 1.得到表格中所有的数据
        List<CheWei> listExcel = getAllByExcel(filePath);
        System.out.println(listExcel.toString());
        System.out.println("=========================ImportExcel listExcel =================");
        // 2.调用业务层代码来处理请求
        CheWeiService service = new CheWeiServiceImpl();
       
        
        // 3.把 listExcel 集合中的数据一个一个插入数据库中
        for(CheWei cheWei:listExcel){
        	System.out.println(cheWei.toString());
        	try {
				boolean result = service.AddCheWei(cheWei);
				if(!result){
					System.out.println("ImportExcel 类中插入  "+cheWei.toString()+" 失败！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        System.out.println("=========================ImportExcel listExcel ================="); 
	}
}
 