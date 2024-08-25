package com.app.entity;

public class Student {

	private Integer studentId;

	private String studentName;

	private String Address;

	private Integer collageId;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer studentId, String studentName, String address, Integer collageId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		Address = address;
		this.collageId = collageId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Integer getCollageId() {
		return collageId;
	}

	public void setCollageId(Integer collageId) {
		this.collageId = collageId;
	}

	
}
