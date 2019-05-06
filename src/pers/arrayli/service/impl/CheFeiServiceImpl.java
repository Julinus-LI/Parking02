package pers.arrayli.service.impl;

import java.sql.SQLException;
import java.util.List;


import pers.arrayli.dao.CheFeiDao;
import pers.arrayli.dao.impl.CheFeiDaoImpl;
import pers.arrayli.domain.CheFei;
import pers.arrayli.domain.PageBean;
import pers.arrayli.service.CheFeiService;

public class CheFeiServiceImpl implements CheFeiService{

	@Override
	public boolean AddCheFei(CheFei cheFei) throws SQLException {
		CheFeiDao dao = new CheFeiDaoImpl();
		return dao.AddCheFei(cheFei);
	}

	@Override
	public List<CheFei> QueryCheFei(String chepai, String date) throws SQLException {
		CheFeiDao dao = new CheFeiDaoImpl();
		return dao.QueryCheFei(chepai, date);
	}

	@Override
	public PageBean findCheFeiByPage(int currentPage,String chepai,String jdate) throws SQLException {
		System.out.println("---------------- CheFeiServiceImpl Debug Start -------------------");
		// 封装分页的改页数据
		PageBean<CheFei> pageBean = new PageBean<CheFei>();
		
		pageBean.setCurrentPage(currentPage);  //设置当前页数
		int pageSize = CheFeiDao.PAGE_SIZE;//设置每页显示的页数
		pageBean.setPageSize(pageSize);

		CheFeiDao dao = new CheFeiDaoImpl();
		List<CheFei> list = dao.findCheFeiByPage(currentPage,chepai,jdate);
		
		for(CheFei cheFei:list){
			System.out.println(cheFei.toString());
		}
		
		pageBean.setList(list); // 设置这一页的学生数据
		
		//总的记录数，总的页数
		int count = dao.findCount(chepai,jdate);
		pageBean.setTotalSize(count); // 设置总的记录数
		
		System.out.println("count :" +count);
		
		pageBean.setTotalPage(count % pageSize == 0 ? count/pageSize : (count/pageSize)+1);
		System.out.println("---------------- CheFeiServiceImpl Debug End -------------------");
		return pageBean;
		
	}
}
 