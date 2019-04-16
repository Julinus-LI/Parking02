package pers.arrayli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.service.CheService;
import pers.arrayli.service.impl.CheServiceImpl;

/**
 * @author lzj13 删除车辆信息 servlet
 */
public class DelCheServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1.获取要删除的车辆信息的 id
			int id = Integer.parseInt(request.getParameter("id"));

			// 2.执行业务层操作
			CheService service = new CheServiceImpl();
			boolean result = service.delCheById(id);
			
			// 如果删除成功的话
			if(result){
				// 重定向到 list.jsp
				response.sendRedirect("che/list.jsp");
			}else{
				// 删除失败的话
				
				// 获取输出流对象
				PrintWriter out = response.getWriter();
				out.println("<script>alert('删除车辆信息失败！');window.location.href='che/list.jsp'</script>");
				out.flush();
				out.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
