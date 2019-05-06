package pers.arrayli.domain;

import java.util.List;

/**
 * @author lzj13
 *	分页显示 bean
 */
public class PageBean<T> {
	private int currentPage; 	 //当前页
	private int totalPage;		// 总页数
	private int  pageSize;		//每页的记录数
	private int totalSize;		//总的记录数
	private List<T> list;		//当前页的停车记录
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ ", totalSize=" + totalSize + ", list=" + list + "]";
	}
}
 