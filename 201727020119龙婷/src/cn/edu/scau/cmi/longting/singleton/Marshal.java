package cn.edu.scau.cmi.longting.singleton;

import java.util.ArrayList;

/**
 * 多例实现十个元帅的创建
 * @author lenovo
 *
 */
public class Marshal {
//	静态变量控制元帅的个数
	private static int NUM = 10;
//	因为最多只能有十个元帅
	private static ArrayList<Marshal> marshals = new ArrayList<>(NUM);
//	每个元帅的名字
	private String name;
	
	private Marshal(String name) {
		this.name = name;
	}
	
	public static Marshal getInstance(String name) {
		if(marshals.size() < NUM) {
			marshals.add(new Marshal(name));
			return marshals.get(marshals.size()-1);
		}else {
			return marshals.get(NUM-1);
		}
	}

	public static int getNUM() {
		return NUM;
	}

	public static void setNUM(int nUM) {
		NUM = nUM;
	}

	public static ArrayList<Marshal> getMarshals() {
		return marshals;
	}

	public static void setMarshals(ArrayList<Marshal> marshals) {
		Marshal.marshals = marshals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
