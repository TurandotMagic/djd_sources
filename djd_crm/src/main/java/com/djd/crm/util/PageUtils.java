package com.djd.crm.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月4日 下午12:59:00
 */
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	//总记录数
	private int totalCount;
	//每页记录数
	private int pageSize;
	//总页数
	private int totalPage;
	//当前页数
	private int currPage;
	//列表数据
	private List<?> list;
	
	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	public boolean needPageNext() {
		
		return ( totalCount - (currPage - 1) * pageSize ) > pageSize;
	}
	
	public boolean needPagePrev() {
		return (currPage - 1) * pageSize  > 0;
	}
	
	
	public static void doPageTurnNxt(int pageNo,PageTurn helper){
		if(pageNo<0){
			return;
		}
		PageUtils page = helper.getData(pageNo);
		helper.handle(page);
		if (page.needPageNext()) {
			page = null;
			doPageTurnNxt(pageNo+1,helper);
		}
	}
	
	
	public static void doPageTurnPre(int pageNo,PageTurn helper){
		if(pageNo<0){
			return;
		}
		PageUtils page = helper.getData(pageNo);
		helper.handle(page);
		if (page.needPagePrev()) {
			page = null;
			doPageTurnPre(pageNo-1,helper);
		}
	}
	
	
	public static void main(String[] args) {
		PageUtils.doPageTurnNxt(1, new PageTurn() {


			@Override
			public PageUtils getData(int pageNo) {
				return new PageUtils(new ArrayList(10), 999, 100, pageNo);
			}
			
			@Override
			public void handle(PageUtils data) {
				System.out.println(data.getCurrPage() +" " + ((data.getCurrPage() - 1) * data.getPageSize()) );
				
			}
		});
	}
	
	
}
