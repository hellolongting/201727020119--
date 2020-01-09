package cn.edu.scau.cmi.longting.adapter;

import java.util.ArrayList;
import java.util.List;


public class SortObjectAdapter implements Sort{
	private SortUtil sortUtil;
	
	@Override
	public List<Student> sortStudents(List<Student> students) {
		sortUtil = new SortUtil();
		List<Student> newStudents =  new ArrayList<Student>();
		List<Integer> sortIntList = new ArrayList<Integer>();
		for(Student student : students) {
			sortIntList.add(student.getNumber());
		}
		sortIntList = sortUtil.sortInt(sortIntList);
		int i;
		for(Integer num : sortIntList) {
			i=0;
			while(i<students.size()) {
				if(num == students.get(i).getNumber()) {
					newStudents.add(students.get(i));
					break;
				}
				i++;
			}
		}
		return newStudents;
	}
}
