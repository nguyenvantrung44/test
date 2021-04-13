package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="LopHoc")
public class LopHoc {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tenLop")
	private String tenLop;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private List<Student> students;
	
	public LopHoc() {
		// TODO Auto-generated constructor stub
	}

	public LopHoc(String tenLop, List<Student> students) {
		super();
		this.tenLop = tenLop;
		this.students = students;
	}

	public LopHoc(int id, String tenLop, List<Student> students) {
		super();
		this.id = id;
		this.tenLop = tenLop;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Student getStudent(int studentID) {

        if(students!=null)
        {
           for(Student student:students)
               if(student.getId()==studentID)
                   return student;
         }
        return null;
	}
	 public void addStudent(Student student) {
	        if (students == null) {
	            students = new ArrayList<>(); }
	        students.add(student);}
}
