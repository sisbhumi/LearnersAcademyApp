package com.backendadmin.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Teacher {
	
	private int teacher_id;
	private String email;
	private String name;
	private String clss;
	private String subject;
	
	public Teacher(int id, String name, String email) {
		
		this.teacher_id =id;
		this.email = email;
		this.name = name;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Set<Student> student = new HashSet<>();
	
	private ClassRoom classroom ;
	
	private Subject subjects;

	public int getId() {
		return teacher_id;
	}

	public void setId(int id) {
		this.teacher_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Teacher() {}
	public Teacher(String name) {
		this.name = name;
	}
	public ClassRoom getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassRoom classroom) {
		this.classroom = classroom;
	}

	public Subject getSubjects() {
		return subjects;
	}

	public void setSubjects(Subject subjects) {
		this.subjects = subjects;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
}
