package cn.edu.scau.cmi.longting.hibernate.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable{

	private Long id;
	private String name;
	private Set students = new HashSet(0);
	
	public Teacher() {
		super();
	}
	public Teacher(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getStudents() {
		return students;
	}
	public void setStudents(Set students) {
		this.students = students;
	}
	
}
