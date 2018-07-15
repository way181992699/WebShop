package com.hd.util;

import java.util.List;

/**
 * ��ҳ�Ĺ�����(����)
 * @author dpb
 * @param <T>
 *
 */
public class BasePage<T> {

	// ��ҳҪ��ʾ������
	private List<T> list;
	// ��ǰҳ��
	private int currentPage;
	// ÿҳ��ʾ������
	private int pageSize;
	// �ܵ�ҳ��
	private int total;
	// �ܵ�����
	private int count;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "BasePage [list=" + list + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", total=" + total
				+ ", count=" + count + "]";
	}
	public BasePage(List<T> list, int currentPage, int pageSize, int total, int count) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.total = total;
		this.count = count;
	}
	public BasePage() {
		super();
	}
	
	
}
