package pers.arrayli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import pers.arrayli.domain.Che;
import pers.arrayli.service.CheService;
import pers.arrayli.service.CheWeiService;
import pers.arrayli.service.impl.CheFeiPriceServiceImpl;
import pers.arrayli.service.impl.CheServiceImpl;
import pers.arrayli.service.impl.CheWeiServiceImpl;


/**
 * @author lzj13
 *	预定车位servlet
 */
public class ReserveServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取输出流对象
		PrintWriter out = response.getWriter();
		try {
			// 获取预定车位 id
			int id = Integer.parseInt(request.getParameter("id"));
			
			// 获取用户 id
			int uid = Integer.parseInt(request.getSession().getAttribute("uid").toString());
			
			System.out.println("id: "+id+"\t"+"uid: "+uid);
			
		/*	// 获取停车类型
			String type = request.getParameter("type");
			
			System.out.println("id: "+id+"\t"+"uid: "+uid+"\ttype: "+type);
			*/
			
			//根据用户 uid  来查询车牌号
 
			CheService service = new CheServiceImpl();
			String hao = service.getHaoByUid(uid);
			
			System.out.println("id: "+id+"\tuid: "+uid+"\thao: "+hao);
			// 如果车牌号不为空的话,可以预定车位
			if(hao != null){
				// 在车位信息表中查询 车牌号为 hao 车有没有停车
				CheWeiService cheWeiService = new CheWeiServiceImpl();
				System.out.println("================== ReserveServlet DEBUG Start =============");
				// 如果已经停车的话
				if(cheWeiService.isReverse(hao)){
					System.out.println("================== ReserveServlet DEBUG End =============");
/*					out
.println("<script>alert('你的车已经停在车位上！');window.location.href='chewei/tlist02.jsp'</script>");*/
					/*out
					.println("<script>alert('你的车已经停在车位上！');window.location.href='chewei/tlist02.jsp'</script>");*/
					//request.getRequestDispatcher("PageListServlet02?currentPage=1&type=UserCheWeiInfo").forward(request, response);
					
					response.sendRedirect("PageListServlet02?currentPage=1&type=UserCheWeiInfo");
					
				}else{
					/*// 如果没有停车的话
					// 1.构造Che对象
					Che che = new Che();
					che.setType(type);
		
					// 2.先把停车类型写入数据库
					CheService service2 = new CheServiceImpl();
					boolean res = service2.UpadteByUid(uid, che);
					if(!res){
						out
						.println("<script>alert('预订失败！');window.location.href='chewei/tlist02.jsp'</script>");
					}*/
					
					// 3.获取当前时间
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = new Date();
					String time = sdf.format(date);
					boolean result = cheWeiService.updateCheWei(hao,time, id);
					
					// 预定成功
					if(result){
				/*		out
.println("<script>alert('预订成功！');window.location.href='chewei/tlist02.jsp'</script>");*/
						response.sendRedirect("PageListServlet02?currentPage=1&type=UserCheWeiInfo");
					}else{
						// 预定失败
						out
.println("<script>alert('预订失败！');window.location.href='chewei/tlist02.jsp'</script>");
					}
				}
			}else{ 
				// 车牌号为空的话，请先添加车辆信息
				out
.println("<script>alert('请添加车辆信息！');window.location.href='chewei/tlist02.jsp'</script>");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
