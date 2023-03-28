package com.backendadmin.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Subject {

	private int sub_id;
	
	private String name;
	
	private Set<Teacher> teacher = new HashSet<>();

	private String classroom ;

	private Set<Student> students = new HashSet<>(); 

	public Set<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}


	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	//getters and setters
	public int getId() {
		return sub_id;
	}

	public void setId(int id) {
		this.sub_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//constructors
	public Subject(int id, String name2, String clss) {
		this.name= name2;
		this.sub_id=id;
		this.classroom= clss;
	}
	public Subject(String name) {
		this.name = name;
	}
	
	
}
