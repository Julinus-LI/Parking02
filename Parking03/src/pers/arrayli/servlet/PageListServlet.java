package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.arrayli.domain.CheFei;
import pers.arrayli.domain.PageBean;
import pers.arrayli.service.CheFeiService;
import pers.arrayli.service.impl.CheFeiServiceImpl;


/**
 * @author lzj13
 *	分页显示
 */	
public class PageListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------PageListServlet Debug Start-------------------------");
		try {
			// 1.获取需要显示的页码
			System.out.println("=====================================");  
			Enumeration en = request.getParameterNames();  
			
			Map<String, String> map = new HashMap<String,String>();
			while(en.hasMoreElements()){  
			    String name = en.nextElement().toString();  
			    String value = request.getParameter(name);
			    System.out.println(name+" = "+value);  
			    map.put(name,value);
			}  
			System.out.println("=====================================");  
			System.out.println(map.toString());
			
			// 获取map里面的currentPage 和 type参数
		
			int currentPage = Integer.parseInt(map.get("currentPage"));
			
			String type = map.get("type");
			System.out.println("从 url中获取到的参数是： "+ "\tcurrentPage = "+currentPage+"\ttype = "+type);
			
			
			// 获取查询条件
			String chepai = request.getParameter("chepai");			// 车牌号
			String jdate = request.getParameter("jdate");			// 入场时间
			
			System.out.println("chepai: "+chepai+"\tjdate: "+jdate);
			System.out.println("currentPage: "+currentPage);
			// 2.根据指定的页数去获取该页的数据回来
			CheFeiService service  = new CheFeiServiceImpl();
			PageBean pageBean =  service.findCheFeiByPage(currentPage,chepai,jdate);
			System.out.println("pageBean.getCurrentPage(): "+pageBean.getCurrentPage());
			System.out.println("pageBean.getPageSize(): "+pageBean.getPageSize());
			System.out.println("pageBean.getTotalPage(): "+pageBean.getTotalPage());
		
			List list = pageBean.getList();
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
			}
			// 3.把数据设置到作用域
			request.setAttribute("pagebean", pageBean);
			System.out.println("--------------PageListServlet Debug End-------------------------");
			// 4.跳转到指定页面
			// 跳转到管理员页面
			if("admin".equals(type)){
				request.getRequestDispatcher("cfei/list.jsp").forward(request, response);
			}else{
				// 跳转到用户页面
				request.getRequestDispatcher("cfei/lslist.jsp").forward(request, response);
			}
			//response.sendRedirect("cfei/lslist.jsp");
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
