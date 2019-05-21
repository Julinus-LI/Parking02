package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.domain.CheFei;
import pers.arrayli.service.CheFeiService;
import pers.arrayli.service.CheWeiService;
import pers.arrayli.service.UserInfoService;
import pers.arrayli.service.impl.CheFeiServiceImpl;
import pers.arrayli.service.impl.CheWeiServiceImpl;
import pers.arrayli.service.impl.UserInfoServiceImpl;


/**
 * @author lzj13
 *	添加车费信息
 */
public class AddCheFeiServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取数据
			String chepai = request.getParameter("chepai");					// 车牌号
			String jdate = request.getParameter("jdate");					// 入场时间
			String ldate = request.getParameter("ldate");					// 离开时间
			int cost = Integer.parseInt(request.getParameter("cost"));		// 停车费用
			int hours = Integer.parseInt(request.getParameter("shijian"));	// 停车时长
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(date);							// 当前时间
			int biaoPrice = Integer.parseInt(request.getParameter("biao"));	// 停车标准价格
			
			// 2.把获取到的数据封装成一个 CheFei 对象
			CheFei chefei = new CheFei();
			chefei.setHao(chepai);
			chefei.setJdate(jdate);
			chefei.setLdate(ldate);
			chefei.setCost(cost);
			chefei.setHours(hours);
			chefei.setAdate(currentTime);
			chefei.setPrice(biaoPrice);
			
			// 3.调用业务层代码来处理请求
			CheFeiService service = new CheFeiServiceImpl();
			// 添加车费
			boolean res1 = service.AddCheFei(chefei);
			
			// 缴费完毕后，车位就成了空位，更新车位
			CheWeiService service2 = new CheWeiServiceImpl();
			boolean res2 = service2.updateCheWeiByChepai(chepai);
			
			// 更新用户卡上余额
			UserInfoService service3 = new UserInfoServiceImpl();
			boolean res3 = service3.updateUserMoney(chepai, cost);
			
			// 如果更新成功
			if(res1 && res2 && res3){
				response.sendRedirect("PageListServlet02?currentPage=1&type=payment");
				//response.getWriter().println("<script>alert('缴费成功！');window.location.href='chewei/jflist02.jsp'</script>");
			}else{
				response.getWriter()
.println("<script>alert('缴费失败！');window.location.href='chewei/jflist02.jsp'</script>");
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
