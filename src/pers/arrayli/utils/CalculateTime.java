package pers.arrayli.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lzj13
 *	计算时间工具类
 */
public class CalculateTime {
	public static int CalculateTime(String jdate,String ldate){
		long diff = 0;
		int hours = 0;
		int temp = 0;
		try {
			String dateStart = jdate;
			String dateEnd = ldate;
			
			// 格式化日期
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = null;
			Date d2 = null;
			// 把字符串日期格式化成日期对象
			d1 = sdf.parse(jdate);
			d2 = sdf.parse(ldate);
			
			// 计算两个时间差的毫秒数
			diff  = d2.getTime()-d1.getTime();
			System.out.println("d2 - d1: "+diff);
			diff = diff / 1000;    // 转换成秒
			
			hours = (int)(diff / 60 / 60);
			temp = ((int)(diff / 60 )) % 60;
			if( temp != 0){
				hours = hours + 1;
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			return hours;
		}
	}
}
 