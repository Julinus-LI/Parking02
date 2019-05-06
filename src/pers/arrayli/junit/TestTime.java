package pers.arrayli.junit;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import pers.arrayli.utils.CalculateTime;
import pers.arrayli.utils.SysInfoUtils;

public class TestTime {

	/**
	 *  测试获取系统信息
	 * @throws UnknownHostException 
	 */
	@Test
	public void testSysInfo() throws UnknownHostException {
		// 打印系统信息
		System.out.println("操作系统："+ "WIN10");
		System.out.println("运行环境："+"Apache Tomcat");
		System.out.println("版本："+ "version-1.0");
		Date date  = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		System.out.println("北京时间： "+ time);
		System.out.println("服务器域名/IP： "+SysInfoUtils.getIP());
		System.out.println("Host："+SysInfoUtils.getHost());
		System.out.println("技术支持");
	}

	@Test
	public void testTimeDiff(){
		String date1 = "2019-04-20 10:00:00";
		String date2 = "2019-04-21 12:30:52";
		long diff = CalculateTime.CalculateTime(date1, date2);
		diff = diff / 1000;   //换算成秒
		// 间隔的年
		int day =(int) (diff / 60 / 60 /24);
		int hour = (int)(diff / 60 / 60);
		int temp = ((int)(diff / 60)) % 60;
		System.out.println("temp = "+temp);
		if(temp != 0){
			hour = hour + 1;
		}
		System.out.println(date2+" 和  "+date1+" 的时间间隔是："+diff);
		System.out.println("相差   "+day+" 天");
		System.out.println("相差  "+ hour+" 小时");
		
		
	}
}
 