package pers.arrayli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import pers.arrayli.domain.Che;
import pers.arrayli.service.CheService;
import pers.arrayli.service.impl.CheServiceImpl;

/**
 * @author lzj13 修改车辆信息servlet
 */
public class ModCheServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取输出流对象
		PrintWriter out = response.getWriter();

		try {
			// 1.从前端页面获取提交上来的数据
			int id = Integer.parseInt(request.getParameter("id"));
			String hao = request.getParameter("hao");
			String leixing = request.getParameter("leixing");
			String picture = request.getParameter("fujian");
			String info = request.getParameter("info");

			// 2.构造一个Javabean 对象
			Che che = new Che();
			che.setId(id);
			che.setHao(hao);
			che.setLeixing(leixing);
			che.setPicture(picture);
			che.setInfo(info);

			// 3.调用业务层代码进行处理
			CheService service = new CheServiceImpl();
			boolean result = service.updateCheById(id, che);
			// 如果修改成功的话
			if (result) {
				// 如果添加成功，重定向到 车的list.jsp
				response.sendRedirect("che/list.jsp");
			} else {
				// 如果修改失败的话
				out.println("<script>alert('修改车辆信息失败！');window.location.href='che/list.jsp'</script>");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		out.flush();
		out.close();
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
