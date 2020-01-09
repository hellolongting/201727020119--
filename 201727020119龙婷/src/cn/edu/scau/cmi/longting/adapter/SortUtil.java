package cn.edu.scau.cmi.longting.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortUtil {
	public List<Integer> sortInt(List<Integer> intList) {
		List<Integer> sortIntList = new ArrayList<Integer>();
		//完成排序功能
		int[] test = new int[intList.size()];
		int k=0;
		while(intList.size()>0) {
			test[k++] = intList.get(0);
			intList.remove(0);
		}
		Arrays.sort(test);
		for(int i=0;i<k;i++) {
			sortIntList.add(test[i]);
		}
		return sortIntList;
	}
}
