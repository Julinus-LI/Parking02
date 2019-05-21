package pers.arrayli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.domain.UserInfo;
import pers.arrayli.service.UserInfoService;
import pers.arrayli.service.impl.UserInfoServiceImpl;


/**
 * @author lzj13
 *	修改用户信息servlet
 */
public class ModUserInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取修改后的用户信息
			
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int age = Integer.parseInt(request.getParameter("age"));
			String tel = request.getParameter("tel");
			System.out.println("修改后的用户信息为： id = "+id+" username= "+username+"  password = "+password+" age = "+age+" tel = "+tel);
			
			// 2.在业务层进行数据处理操作
			UserInfoService service = new UserInfoServiceImpl();
			UserInfo user  = new UserInfo();
			user.setId(id);
			user.setUsername(username);
			user.setPwd(password);
			user.setAge(age);
			user.setTel(tel);
			service.update(id, user);
		
			// 获取输出流对象
			PrintWriter out = response.getWriter();
			
			// 获取用户类型，判断登录用户是为空
			String type = request.getParameter("type");
			
			// 如果是普通用户执行
			if(type != null && type.length() >0){
				out.
println("<script>alert('修改成功！');window.location.href='userinfo/myUserinfo.jsp'</script>");
			}else{	
				// 如果是管理员用户重定向到 list.jsp
				response.sendRedirect("userinfo/list.jsp");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
