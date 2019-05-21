package pers.arrayli.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.CheFeiPrice;

/**
 * @author lzj13
 *	计算时间工具类
 */
public class CalculateTime {
	
	/**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     * 
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime){
    	Calendar date = Calendar.getInstance();
    	date.setTime(nowTime);
    	Calendar begin = Calendar.getInstance();
    	begin.setTime(beginTime);
    	Calendar end = Calendar.getInstance();
    	end.setTime(endTime);
    	if (date.after(begin) && date.before(end)) {
    		 return true;
    	}else if (nowTime.compareTo(beginTime) == 0 || nowTime.compareTo(endTime) == 0) {
    		 return true;
    	}else {
            return false;
    	}
    }
    // 字符串 转 日期
    public static Date strToDate(String str,String format) {
    	 SimpleDateFormat sdf = new SimpleDateFormat(format);
    	 Date date = null;
    	 try {
    		 date = sdf.parse(str);
    	 } catch (ParseException e) {
    	 
    	 }
         	return date;
    }
	
	
	/**
	 * @param jdate  入场时间
	 * @param ldate	 离场时间
	 * @return  停车时长
	 */
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
	
	/**根据所给时间来获取时分秒
	 * @param time 所给时间
	 * @return 时分秒
	 */
	public static String getHMS(String time){
		String  []temp = time.split(" ");
		return temp[1];
	}
	
	/**根据入场时间和离场时间来判断是否白天12小时内
	 * @param jdate  入场时间
	 * @param ldate	 离场时间
	 * @return	12小时是否在白天停车
	 */
	public static int isDay(String jdate,String ldate){
		// 2019-05-19 14:40:49
		jdate = getHMS(jdate);
		ldate = getHMS(ldate);
		String format = "HH:mm:ss";
		// 开始时间
		Date effectivetime = strToDate("06:00:00",format);
		// 失效时间
		Date invalidtime = strToDate("18:00:00",format);
   	 
		Date inDate = strToDate(jdate,format);
		Date outDate = strToDate(ldate, format);
		
		boolean in = belongCalendar(inDate, effectivetime, invalidtime);
		boolean out  = belongCalendar(outDate, effectivetime, invalidtime);
		
		if(in && out){
			return 1;
		}
		return 0;
	}
	
	/**把时间转换成 30进制的 ，夜晚停车从 18:00:00-06:00:00 -- 转换成 18:00:00-30:00:00 
	 * @param time 时分秒时间  HH:mm:ss
	 * @return	30进制时间
	 */ 
	public static String ChangeTime(String time){
		String []temp  = time.split(":");
    	System.out.println(time);
    	for(String s:temp){
    		System.out.println(s);
    	}
    	int hours = Integer.parseInt(temp[0]);
    	int mins =  Integer.parseInt(temp[1]);
    	int ss = Integer.parseInt(temp[2]);
 
    	System.out.println("hours: "+hours);
    	System.out.println("mins: "+mins);
    	System.out.println("ss: "+ss);
    	if(hours <= 18){
    		hours = 24 + hours;
    	}
    	
    	time = null;
    	time = String.valueOf(hours) +":";
    	if(mins < 10){
    		time = time + String.valueOf(0)+String.valueOf(mins)+":";
    	}else{
    		time = time + String.valueOf(mins)+":";
    	}
    	if(ss<10){
    		time = time + String.valueOf(0)+String.valueOf(ss);
    	}else{
    		time = time + String.valueOf(ss);
    	}
    	
		return time;
	}
	
	
	
	
	/**根据入场时间和离场时间来判断是否晚上12小时内
	 * @param jdate  入场时间
	 * @param ldate	 离场时间
	 * @return	12小时是否在晚上停车
	 */
	public static int isNight(String jdate,String ldate){
		// 2019-05-19 14:40:49
		String tempJdate = getHMS(jdate);
		String tempLdate = getHMS(ldate);
		String format = "HH:mm:ss";
		
		// 把时间转换成 30进制的 ，夜晚停车从 18:00:00-06:00:00 -- 转换成 18:00:00-30:00:00 
		tempJdate = ChangeTime(tempJdate);
		tempLdate = ChangeTime(tempLdate);
		
		//18:00:00 - 30:00:00
		// 开始时间
		Date effectivetime = strToDate("18:00:00",format);
		// 失效时间
		Date invalidtime = strToDate("30:00:00",format); 
		
		Date inDate = strToDate(tempJdate, format);
		Date outDate = strToDate(tempLdate,format);
		boolean in = belongCalendar(inDate,effectivetime,invalidtime);
		boolean out = belongCalendar(outDate,effectivetime,invalidtime);
	
		if(in && out){
			return 2;
		}
		return 0;
	}
	
	/**根据入场时间和离场时间来判断是否晚上12小时内
	 * @param jdate  入场时间
	 * @param ldate	 离场时间
	 * @return	12小时是否在晚上停车
	 */
	public static int isDayAndNight(String jdate,String ldate){
		// 2019-05-19 14:40:49
		jdate = getHMS(jdate);
		ldate = getHMS(ldate);
		String format = "HH:mm:ss";
		// 开始时间
		Date effectivetime = strToDate("06:00:00",format);
		// 失效时间
		Date invalidtime = strToDate("18:00:00",format);
		   	 
	    Date inDate = strToDate(jdate,format);
		// 判断 jdate这个时间是否在 18:00:00-23:59:59之间
		boolean in = belongCalendar(inDate, effectivetime, invalidtime);
				
		
		// 判断 ldate这个时间是否在 00:00:00-06:00:00之间
		effectivetime = strToDate("18:00:00",format);
		invalidtime = strToDate("30:00:00",format);
		
		ldate = ChangeTime(ldate);
		Date outDate = strToDate(ldate, format);
		boolean out  = belongCalendar(outDate, effectivetime, invalidtime);
				
		if(in && out){
			return 3;
		}
		return 0;
	}
	
	
	/**通过进场和离场的时间来计算停车属于哪一种车费信息类型
	 * @param jdate	入场时间
	 * @param ldate	离场时间
	 * @return	车费价格类型信息
	 * @throws SQLException
	 */
	public static CheFeiPrice getCheFeiPriceInfo(String jdate,String ldate) throws SQLException{
		// 1.链接数据库
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String  sql = "select * from t_price where id = ?";
		// 2. 先判断两个时间差
		int hours = CalculateTime(jdate,ldate);
		System.out.println("hours: "+hours);
		int id = 0;
		// 如果大于 24 小时，则按月收费
		if(hours > 24*12){	 // 如果停车超过12天，则按一个月收费
			id = 8;
		}else if(hours == 24){  	// 等于 24 小时按天收费
			id = 7;
		}else{  // 小于24小时
			if(hours > 12 ){  		// 大于12小时按24小时收费
				id = 7;
			}else{  // 处理白天12小时，晚上 12 小时 ，白天加晚上停车 12 小时
				// 白天 12 小时
				// 如果师白天 12 小时
				if(isDay(jdate, ldate) != 0 ){
					if(hours <= 2){
						id = 1;
					}else if(hours > 2 && hours <= 4){
						id = 2;
					}else{
						id = 3;
					}
				}
				if(isNight(jdate, ldate) != 0){
					if(hours <= 4){
						id = 4;
					}else{
						id = 5;
					}
				}
				if(isDayAndNight(jdate, ldate) != 0){
					id = 6;
				}
			}
		}
		
		
		CheFeiPrice cheFeiPrice = queryRunner.query(sql,new BeanHandler<CheFeiPrice>(CheFeiPrice.class),id);
		
		return cheFeiPrice;
	} 
	
	public static void main(String args[]){
		/*String time = "19:05:11";
		System.out.println(time);
		
		time = ChangeTime(time);
		
		System.out.println(time);*/
		
		String jdate = "2019-05-19 06:55:30";
		String ldate = "2019-05-19 17:30:59";
		
		try {
			CheFeiPrice cheFeiPrice = getCheFeiPriceInfo(jdate, ldate);
			System.out.println(cheFeiPrice.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(isDay(jdate, ldate) == 0){
			System.out.println("是夜晚");
		}else{
			System.out.println("是白天");
		}	
	
		if(isNight(jdate, ldate) == 0){
			System.out.println("是白天");
			
		}else{
			System.out.println("是夜晚");
		}	
		
		if(isDayAndNight(jdate, ldate) == 0){
			System.out.println("是白天");
			
		}else{
			System.out.println("是白加黑");
		}	
		
	}
	
}
 