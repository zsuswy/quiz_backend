package com.ronmob.qz.model.common;

public class Page {

	private int pageNO = 1;

	private int everyPageCount = 10;

	private int totalCount;

	private int firstResult;

	public int getPageNO() {
		return pageNO;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}

	public int getEveryPageCount() {
		return everyPageCount;
	}

	public void setEveryPageCount(int everyPageCount) {
		this.everyPageCount = everyPageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getFirstResult() {
		if (everyPageCount != 0 && pageNO != 0) {
			firstResult = (pageNO - 1) * everyPageCount;
		}
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getLimit() {
		return everyPageCount;
	}

	public int getOffset() {
		return (pageNO - 1) * everyPageCount;
	}
}
