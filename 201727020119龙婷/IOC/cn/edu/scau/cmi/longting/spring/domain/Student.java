package cn.edu.scau.cmi.longting.spring.domain;

import java.io.Serializable;

public class Student implements Serializable{
	
	private String id;
	private String name;
	private String gender;
	private Teacher tutor;
	private static final long serializableUID = 1L;
	
	public Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Teacher getTutor() {
		return tutor;
	}

	public void setTutor(Teacher tutor) {
		this.tutor = tutor;
	}

	public static long getSerializableuid() {
		return serializableUID;
	}
	
}
