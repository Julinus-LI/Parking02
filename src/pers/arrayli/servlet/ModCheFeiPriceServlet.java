package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.domain.CheFeiPrice;
import pers.arrayli.service.CheFeiPriceService;
import pers.arrayli.service.impl.CheFeiPriceServiceImpl;


/**
 * @author lzj13
 *	修改车费价格 servlet
 */
public class ModCheFeiPriceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取车费价格数据
			int id = Integer.parseInt(request.getParameter("id"));
			int price = Integer.parseInt(request.getParameter("price"));
			
			// 2.把车费价格封装成一个 CheFeiPrice对象
			CheFeiPrice cheFeiPrice = new CheFeiPrice();
			cheFeiPrice.setPrice(price);
			cheFeiPrice.setId(id);
			
			// 3.通过业务层代码处理请求
			CheFeiPriceService service = new CheFeiPriceServiceImpl();
			boolean result = service.setFare(id, cheFeiPrice);
			// 如果修改车费价格成功
			if(result){
				
			}else{
				// 如果修改车费结果失败
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
