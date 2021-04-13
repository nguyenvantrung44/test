package com.dto;

import java.util.List;

import com.model.LopHoc;
import com.model.Student;

public class LopHocDTO {
	private LopHoc lop;
	private List<Student> students;
	public LopHoc getLop() {
		return lop;
	}
	public void setLop(LopHoc lop) {
		this.lop = lop;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
