package com.example.orderserver.bean;

import lombok.Data;

import java.util.List;

@Data
public class SubItem<T> {

	private List<T> listData;

	private List<Integer> deletedIdAry;

	public SubItem() {
	}

	public SubItem(List<T> listData) {
		this.listData = listData;
	}
}
