package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.service.UserInfoService;
import pers.arrayli.service.impl.UserInfoServiceImpl;


/**
 * @author lzj13
 *	删除用户信息 servlet
 */
public class DelUserInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取删除用户的用户 id
			int uid  = Integer.parseInt(request.getParameter("id"));
			System.out.println("要删除的用户id为： "+uid);
			// 2.执行业务层代码处理客户端请求
			UserInfoService service = new UserInfoServiceImpl();
			boolean result = service.DelUseInfo(uid);
			//如果删除成功的话
			if(result){
				// 重定向到 userinfo/list.jsp
				response.sendRedirect("userinfo/list.jsp");	
			}else{
				// 如果删除失败的话
				response.getWriter()
.println("<script>alert('删除用户信息失败！');window.location.href='userinfo/list.jsp'</script>");
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
