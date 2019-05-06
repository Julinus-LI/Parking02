package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.service.CheWeiService;
import pers.arrayli.service.impl.CheWeiServiceImpl;


/**
 * @author lzj13
 *	删除车位信息 servlet
 */
public class DelCheweiServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取删除车位信息的车位 id
			int id = Integer.parseInt(request.getParameter("id"));
			
			// 2.通过业务层代码来执行请求
			CheWeiService service = new CheWeiServiceImpl();
			boolean result = service.DelCheWeiById(id);
			// 如果删除成功
			if(result){
				response.sendRedirect("chewei/list.jsp");	
			}else{
				// 如果删除失败
				// 如果更新失败
				response.getWriter()
	.println("<script>alert('删除车位信息失败！');window.location.href='chewei/list.jsp'</script>");
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
