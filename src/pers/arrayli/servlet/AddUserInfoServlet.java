package pers.arrayli.servlet;

import java.io.IOException;
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
 *	添加用户信息 servlet
 */
public class AddUserInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取前端页面的数据
			String username = request.getParameter("name");
			String password = request.getParameter("pwd");
			int age = Integer.parseInt(request.getParameter("age"));
			String tel = request.getParameter("tel");
			
			// 2.把获取到的用户信息封装成一个 UserInfo 对象
			UserInfo user = new UserInfo();
			user.setUsername(username);
			user.setPwd(password);
			user.setAge(age);
			user.setTel(tel);
			
			// 3.执行业务层代码
			UserInfoService service = new UserInfoServiceImpl();
			boolean result = service.addUserInfo(user);
			// 如果添加用户信息成功
			if(result){
				// 重定向到   userinfo/list.jsp
				response.sendRedirect("userinfo/list.jsp");
			}else{
				// 如果添加用户信息失败
				response.getWriter()
.println("<script>alert('添加用户信息失败！');window.location.href='userinfo/list.jsp'</script>");
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
