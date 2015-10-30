package com.demo;

import java.io.Serializable;

public class RanNe implements Serializable{

	private static final long serialVersionUID = 7322960239024295442L;
	private String neName;
	private int neId;
	
	public String getNeName() {
		return neName;
	}
	public void setNeName(String neName) {
		this.neName = neName;
	}
	public int getNeId() {
		return neId;
	}
	public void setNeId(int neId) {
		this.neId = neId;
	}
}
