package pers.arrayli.junit;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import pers.arrayli.utils.SysInfoUtils;

public class TestLogin {

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

}
 