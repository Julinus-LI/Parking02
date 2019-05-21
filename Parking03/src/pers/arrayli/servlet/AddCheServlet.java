package pers.arrayli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.domain.Che;
import pers.arrayli.service.CheService;
import pers.arrayli.service.impl.CheServiceImpl;

/**
 * Servlet implementation class AddCheServlet
 */
public class AddCheServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1.从前端页面获取数据
			String hao = request.getParameter("hao");
			String leixing = request.getParameter("leixing");
			String picture = request.getParameter("fujian");
			String info = request.getParameter("info");
			int uid = Integer.parseInt(request.getSession().getAttribute("uid").toString());

			System.out.println("-------------------添加车辆信息---------------");
			

			// 2.封装车信息
			Che che = new Che();
			che.setHao(hao);
			che.setLeixing(leixing);
			che.setInfo(info);
			che.setPicture(picture);
			che.setUid(uid);
			
			System.out.println(che.toString());
			System.out.println("-------------------添加车辆信息---------------");
			
			// 3.进行业务层操作，把车的信息写入数据库中
			CheService service = new CheServiceImpl();
			boolean result = service.AddChe(che);
			System.out.println("AddCheServlet: result ="+result);
			// 如果添加成功
			if(result){
				// 如果添加成功，重定向到  车的list.jsp
				response.sendRedirect("che/list.jsp");
			}else{
				// 如果登录失败的话
				// 获取输出流对象
				PrintWriter out = response.getWriter();
				out.println("<script>alert('添加车辆失败！');window.location.href='che/list.jsp'</script>");
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
