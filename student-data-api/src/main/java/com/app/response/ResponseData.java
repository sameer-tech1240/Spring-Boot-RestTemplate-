package com.app.response;

import com.app.entity.Student;

public class ResponseData {

	private Student student;

	private Collage collage;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Collage getCollage() {
		return collage;
	}

	public void setCollage(Collage collage) {
		this.collage = collage;
	}

	public ResponseData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseData(Student student, Collage collage) {
		super();
		this.student = student;
		this.collage = collage;
	}

}
