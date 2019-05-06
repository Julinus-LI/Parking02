package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.service.AdminUserService;
import pers.arrayli.service.impl.AdminUserServiceImpl;


/**
 * @author lzj13
 *	删除管理员信息 servlet
 */
public class DelAdminServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取要删除的管理员 id
			int  id = Integer.parseInt(request.getParameter("id"));
			
			// 2. 调用业务层代码来来处理客户端请求
			AdminUserService service = new AdminUserServiceImpl();
			boolean result = service.delAdminById(id);	
			// 删除管理员信息成功
			if(result){
				// 重定向到 admin/list.jsp页面
				response.sendRedirect("admin/list.jsp");
				
			}else{
				// 删除管理员失败
				// 如果修改失败的话
				response.getWriter().
	println("<script>alert('删除管理员信息失败！');window.location.href='admin/list.jsp'</script>");		
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
