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
 *	添加车位信息
 */
public class AddCheweiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取车位信息数据
			String hao = request.getParameter("hao");
			String quyu = request.getParameter("qu");
			String info = request.getParameter("info");
			
			// 2.把车位信息封装成一个 CheWei 对象
			CheWei cheWei = new CheWei();
			cheWei.setHao(hao);
			cheWei.setQuyu(quyu);
			cheWei.setInfo(info);
			cheWei.setId(0);
			cheWei.setChepai(null);
			cheWei.setAdate(null);
			
			System.out.println("添加的车位信息："+cheWei.toString());
			
			
			// 3.执行业务层代码来处理请求
			CheWeiService service = new CheWeiServiceImpl();
			boolean result = service.AddCheWei(cheWei);
			// 如果添加车位信息成功
			if(result){
				//response.sendRedirect("chewei/list02.jsp");	
				response.sendRedirect("PageListServlet02?currentPage=1&type=CheWeiManagement");	
				//request.getRequestDispatcher("PageListServlet02?currentPage=1&type=CheWeiManagement").forward(request,response);	
			}else{
				// 如果添加车位信息失败
				// 如果更新失败
				response.getWriter()
.println("<script>alert('添加车位信息失败！');window.location.href='chewei/list02.jsp'</script>");
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
