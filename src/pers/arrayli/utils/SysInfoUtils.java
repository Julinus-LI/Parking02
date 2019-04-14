package pers.arrayli.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.tomcat.jni.OS;

/**
 * @author lzj13
 *	获取服务器的IP地址和Host
 */
public class SysInfoUtils {
	public static String os = "WIN10";    // 操作系统
	public static String RunEnvironment = "Apache Tomcat";  //	运行环境
	public static String version = "version-1.0";	//	系统版本
	public static InetAddress addr = null; 
	/**	获取服务器的IP地址
	 * @return 返回服务器的 IP地址
	 * @throws UnknownHostException
	 */
	public static String getIP() throws UnknownHostException{
		addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress();
		System.out.println("ip : "+ip);
		return ip;
	}
	
	public static String getHost(){
		String host = addr.getHostName();
		System.out.println("host: "+host);
		return host;
	}
}  
	
 