package com.example.orderserver.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IdName {

	private Serializable id;

	private Serializable name;

	private List<IdName> children;


	public IdName() {
	}

	public IdName(Serializable id, Serializable name) {
		this.id = id;
		this.name = name;
	}

	public IdName(Serializable id, Serializable name, List<IdName> children) {
		this.id = id;
		this.name = name;
		this.children = children;
	}
}
