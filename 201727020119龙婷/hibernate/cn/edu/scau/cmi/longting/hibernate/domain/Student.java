package cn.edu.scau.cmi.longting.hibernate.domain;

import java.io.Serializable;

public class Student implements Serializable{

	private Long id;
	private String name;
	//private Long tutor;
	private Teacher teacher;
	
	public Student() {
		super();
	}
	public Student(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student(Long id, String name, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	/**
	 * public Long getTutor() {
		return tutor;
	}
	public void setTutor(Long tutor) {
		this.tutor = tutor;
	}
	 */
	
}
