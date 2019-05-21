package pers.arrayli.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import pers.arrayli.utils.EchartsDataUtils;

/**
 * @author lzj13 主要用于绘制统计图信息
 */
public class EchartsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====================EchartsServlet====================");
		// 1.首先获取类型，判断是绘制条形统计图还是扇形统计图
		String type = request.getParameter("type");
		System.out.println("type: " + type);

		// 如果是绘制条形统计图
		if ("Bar".equals(type)) {
			// 1.从数据库中获取数据
			
			List<Integer> listCost = null;
			List<Integer> listNums = null;
			try {
				// 12个月，每个月的总计费用
				listCost = EchartsDataUtils.getAllMonsCost();
				// 12个月，每个月的停车次数和
				listNums = EchartsDataUtils.getAllMonsNums();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 销量 
			List<Integer> salesVolume = new ArrayList<Integer>();
			 营业额 
			List<Integer> bussinessVolume = new ArrayList<Integer>();
			if (list != null) {
				for (Goods goods : list) {

					salesVolume.add(goods.getSales());
					bussinessVolume.add(goods.getStock());
				}
			}*/
			/* 横轴, 月份数据 */
			String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

			Map<String, Object> map = new HashMap<>();
			map.put("listCost", listCost);
			map.put("listNums", listNums);
			map.put("months", months);

			response.getWriter().println(JSON.toJSONString(map));

		}
		if ("Pip".equals(type)) {
			
			
			try {
				// 1.从数据库获取数据
				List<Integer> listChweiNums = EchartsDataUtils.getAllCheWeiNums();
				int freeNums = listChweiNums.get(1);
				int busyNums = listChweiNums.get(0);
				Map<String, Object> map = new HashMap<>();
				map.put("freeNums", freeNums);
				map.put("busyNums",busyNums);
				
				
				response.getWriter().println(JSON.toJSONString(map));
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("====================EchartsServlet====================");
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
