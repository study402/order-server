package com.example.orderserver.bean;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 分页信息
 */
public class PageResult<T> extends ResponseResult {

	public PageResult() {
	}

	public PageResult(int resultCode, String msg) {
		this.setResultCode(resultCode);
		this.setMsg(msg);
	}

	public Long getTotal() {
		return this.getLong("total");
	}

	public void setTotal(Long total) {
		this.put("total", total);
	}

	public Long getPage() {
		Long page = this.getLong("page");
		return page == null ? 1 : page;
	}

	public void setPage(Long page) {
		this.put("page", page);
	}

	public Long getPageSize() {
		Long pageSize = this.getLong("pageSize");
		return pageSize == null ? 10 : pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.put("pageSize", pageSize);
	}

	public List<T> getListData() {
		return this.getObject("listData", new TypeReference<List<T>>() {
		});
	}

	public void setListData(List<T> listData) {
		this.put("listData", listData);
	}

	public long getFrom() {
		return (getPage() - 1) * getPageSize();
	}

	public PageResult(QueryParam queryParam, List<T> list, long total) {
		this.setPage(queryParam.getPage());
		this.setPageSize(queryParam.getPageSize());
		this.setListData(list);
		this.setTotal(total);
	}

	public PageResult(List<T> list, long total) {
		this.setListData(list);
		this.setTotal(total);
	}

	public PageResult(QueryParam queryParam, List<T> list) {
		this.setPage(queryParam.getPage());
		this.setPageSize(queryParam.getPageSize());
		this.setListData(list);
	}

	public PageResult(QueryParam queryParam) {
		this.setPage(queryParam.getPage());
		this.setPageSize(queryParam.getPageSize());
	}

	public PageResult(IPage<T> page) {
		this.setPage(page.getCurrent());
		this.setPageSize(page.getSize());
		this.setListData(page.getRecords());
		this.setTotal(page.getTotal());
	}
}
