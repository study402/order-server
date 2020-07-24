package com.example.orderserver.bean;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

public class QueryParam extends JSONObject {

	public QueryParam() {
		this(1, 10);
	}

	public QueryParam(int page, int pageSize) {
		setPage(page);
		setPageSize(pageSize);
	}

	public long getPage() {
		Long page = this.getLong("page");
		return page == null ? 1 : page;
	}

	public void setPage(int page) {
		this.put("page", page);
	}

	public long getPageSize() {
		Long pageSize = this.getLong("pageSize");
		return pageSize == null ? 10 : pageSize;
	}

	public void setPageSize(long pageSize) {
		this.put("pageSize", pageSize);
	}

	public long getPageNumber() {
		return getPage() - 1;
	}

	public long getOffset() {
		return (getPage() - 1) * getPageSize();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> data = this.getInnerMap();
		data.put("page", getPage());
		data.put("pageSize", getPageSize());
		data.put("offset", getOffset());
		return data;
	}

	public <T> IPage<T> toPage() {
		return new Page<>(getPage(), getPageSize());
	}
}
