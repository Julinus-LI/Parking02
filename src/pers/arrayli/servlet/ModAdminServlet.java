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
 *	修改管理员信息
 */
public class ModAdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.从前端页面获取管理员信息
			
			int id = Integer.parseInt(request.getParameter("id"));
			String userName = request.getParameter("name");
			String passWord = request.getParameter("pwd");
			
			// 2.把获取到的信息封装成一个 AdminUser对象
			AdminUser admin = new  AdminUser();
			admin.setUserName(userName);
			admin.setUserPassword(passWord);
			System.out.println("id: "+id+"\tadmin: "+admin.toString());
			
			// 3.业务层处理前端页面请求
			AdminUserService service = new AdminUserServiceImpl();
			boolean result = service.updateAdminById(id, admin);
			// 如果修改成功的话
			if(result){
				// 重定向到 admin/list.jsp
				response.sendRedirect("admin/list.jsp");
			}else{
					// 如果修改失败的话
				// 如果修改失败的话
				response.getWriter().println("<script>alert('修改管理员信息失败！');window.location.href='admin/list.jsp'</script>");
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
