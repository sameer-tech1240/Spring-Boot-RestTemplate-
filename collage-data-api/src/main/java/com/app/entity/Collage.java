package com.app.entity;

public class Collage {

	private Integer collageId;

	private String collageName;

	private String address;

	public Collage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collage(Integer collageId, String collageName, String address) {
		super();
		this.collageId = collageId;
		this.collageName = collageName;
		this.address = address;
	}

	public Integer getCollageId() {
		return collageId;
	}

	public void setCollageId(Integer i) {
		this.collageId = i;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
