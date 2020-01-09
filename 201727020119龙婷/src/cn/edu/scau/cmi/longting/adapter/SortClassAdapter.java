package cn.edu.scau.cmi.longting.adapter;

import java.util.ArrayList;
import java.util.List;

public class SortClassAdapter extends SortUtil implements Sort{

	@Override
	public List<Student> sortStudents(List<Student> students) {
		List<Student> newStudents =  new ArrayList<Student>();
		List<Integer> sortIntList = new ArrayList<Integer>();
		for(Student student : students) {
			sortIntList.add(student.getNumber());
		}
		sortIntList = this.sortInt(sortIntList);
		int i,num;
		for(int k=0;k < sortIntList.size(); k++) {
			num = sortIntList.get(k);
			i=0;
			while(i<students.size()) {
				if(num == students.get(i).getNumber()) {
					newStudents.add(students.get(i));
					break;
				}
				i++;
			}
		}
//		System.out.println("排好序的学生数组： "+newStudents.size());
//		for(int k=0;k<newStudents.size();k++) {
//			System.out.println("number : "+newStudents.get(k).getNumber()+" , name : "+newStudents.get(k).getName());
//		}
		return newStudents;
	}

}
