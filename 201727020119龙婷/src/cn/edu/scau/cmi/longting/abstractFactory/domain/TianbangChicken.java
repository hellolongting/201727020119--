package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Chicken;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Tianbang;

public class TianbangChicken extends Chicken implements Tianbang {

	@Override
	public void culture() {
		System.out.println("这是天邦养殖的鸡肉!!!");
		System.out.println(super.name+Tianbang.brand);
		
	}
	
}
