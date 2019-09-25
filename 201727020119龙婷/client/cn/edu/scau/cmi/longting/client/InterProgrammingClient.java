package cn.edu.scau.cmi.longting.client;

import cn.edu.scau.cmi.longting.interProgramming.GraduateStudent;
import cn.edu.scau.cmi.longting.interProgramming.Student;
import cn.edu.scau.cmi.longting.interProgramming.UndergraduateStudent;

public class InterProgrammingClient {

	public static void main(String[] args) {
		Student graduateStudent = new GraduateStudent();
		graduateStudent.learning();
		
		Student undergraduateStudent = new UndergraduateStudent();
		undergraduateStudent.learning();
		
	}

}
