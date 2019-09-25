package cn.edu.scau.cmi.longting.singleton;

import java.util.ArrayList;

/**
 * ����ʵ��ʮ��Ԫ˧�Ĵ���
 * @author lenovo
 *
 */
public class Marshal {
//	��̬��������Ԫ˧�ĸ���
	private static int NUM = 10;
//	��Ϊ���ֻ����ʮ��Ԫ˧
	private static ArrayList<Marshal> marshals = new ArrayList<>(NUM);
//	ÿ��Ԫ˧������
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
