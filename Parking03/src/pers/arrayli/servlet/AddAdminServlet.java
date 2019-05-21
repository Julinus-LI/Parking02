package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.domain.AdminUser;
import pers.arrayli.service.AdminUserService;
import pers.arrayli.service.impl.AdminUserServiceImpl;


/**
 * @author lzj13
 *	添加管理员信息
 */
public class AddAdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			// 1. 获取客户端数据
			String userName = request.getParameter("name");
			String userPassword = request.getParameter("pwd");
			
			// 2. 把数据封装成一个 AdminUser对象
			AdminUser admin = new AdminUser();
			admin.setUserName(userName);
			admin.setUserPassword(userPassword);
			
			// 3.调用业务层代码来处理请求
			AdminUserService service = new AdminUserServiceImpl();
			boolean result = service.addAdmin(admin);
			// 如果添加管理员信息成功
			if(result){
				// 如果添加成功，重定向到  admin/list.jsp
				response.sendRedirect("admin/list.jsp");
			}else{
				// 如果添加失败
				response.getWriter()
	.println("<script>alert('添加管理员失败！');window.location.href='admin/list.jsp'</script>");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
