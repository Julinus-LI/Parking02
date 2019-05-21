package pers.arrayli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.dao.impl.UserInfoDaoImpl;
import pers.arrayli.domain.UserInfo;
import pers.arrayli.service.UserInfoService;
import pers.arrayli.service.impl.UserInfoServiceImpl;

/**
 * @author lzj13 用户注册 servlet
 */
public class UserRegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取输出流对象
		PrintWriter out = response.getWriter();

		// 1.从前端页面获取数据
		String username = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		int age = Integer.parseInt(request.getParameter("age"));
		String tel = request.getParameter("tel");
		String type = request.getParameter("type");

		// 2.把获取到的注册信息封装成一个用户信息对象
		UserInfo user = new UserInfo();
		user.setUsername(username);
		user.setPwd(pwd);
		user.setAge(age);
		user.setTel(tel);
		user.setMoney(0);
		System.out.println("type: " + type);
		if ("0".equals(type)) {
			/*
			 * request.getRequestDispatcher("userinfo/regUserinfo.jsp").forward(
			 * request, response);
			 */
			out.println("<script>alert('没有选择用户类型,请重新注册！');window.location.href='userinfo/regUserinfo.jsp'</script>");
		} else {
			user.setType(type);
			System.out.println("Register user: " + user.toString());

			try {

				// 3.调用业务层代码，处理请求
				UserInfoService service = new UserInfoServiceImpl();
				boolean result = service.RegisterUser(user);
				// 如果注册成功
				if (result) {
					out.println("<script>alert('注册成功请登录！');window.location.href='login.jsp'</script>");

				} else { // 如果注册失败
					out.println(
							"<script>alert('注册成功失败,请重新注册！');window.location.href='userinfo/regUserinfo.jsp'</script>");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.flush();
			out.close();
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
