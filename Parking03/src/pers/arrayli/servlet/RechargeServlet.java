package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.domain.CheFeiPrice;
import pers.arrayli.domain.UserInfo;
import pers.arrayli.service.CheFeiPriceService;
import pers.arrayli.service.UserInfoService;
import pers.arrayli.service.impl.CheFeiPriceServiceImpl;
import pers.arrayli.service.impl.UserInfoServiceImpl;


/**
 * @author lzj13
 *	充值 servlet   主要用来处理jsp页面的充值请求
 */
public class RechargeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取数据
			int id = Integer.parseInt(request.getParameter("id"));
			int money = Integer.parseInt(request.getParameter("money"));
			// 3.通过业务层代码对请求进行处理
			UserInfoService service = new UserInfoServiceImpl();
			boolean result = service.UserRecharge(id, money);
			// 如果充值成功
			if(result){
				
				response.getWriter()
	.println("<script>alert('充值成功！');window.location.href='userinfo/list.jsp'</script>");
				// 如果添加成功，重定向到  userinfo/list.jsp
				//response.sendRedirect("userinfo/list.jsp");
			}else{
				// 如果充值失败
				response.getWriter()
	.println("<script>alert('充值失败！');window.location.href='userinfo/list.jsp'</script>");
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
