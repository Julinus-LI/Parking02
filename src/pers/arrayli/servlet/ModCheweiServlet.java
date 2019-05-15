package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.domain.CheWei;
import pers.arrayli.service.CheWeiService;
import pers.arrayli.service.impl.CheWeiServiceImpl;


/**
 * @author lzj13
 *	修改车位信息 servlet
 */
public class ModCheweiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			// 1.获取要修改的车位信息 id
			int id = Integer.parseInt(request.getParameter("id"));
			String hao = request.getParameter("hao");
			String quyu = request.getParameter("quyu");
			String info = request.getParameter("info");
			
			// 2. 把车位信息封装成一个 CheWei 对象
			CheWei cheWei = new CheWei();
			cheWei.setHao(hao);
			cheWei.setInfo(info);
			cheWei.setQuyu(quyu);
			
			// 3.调用业务层代码处理请求
			CheWeiService service = new CheWeiServiceImpl();
			boolean result = service.updateCheWeiById(id, cheWei);
			// 如果更新成功
			if(result){
				//response.sendRedirect("chewei/list02.jsp");
				//<%=path %>/PageListServlet02?currentPage=1&type=CheWeiManagement
				response.sendRedirect("PageListServlet02?currentPage=1&type=CheWeiManagement");
				//request.getRequestDispatcher("chewei/list02.jsp");
			}else{
				// 如果更新失败
				response.getWriter()
	.println("<script>alert('更新车位信息失败！');window.location.href='chewei/list02.jsp'</script>");
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
