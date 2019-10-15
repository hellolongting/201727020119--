package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Chicken;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Wens;

public class WensChicken extends Chicken implements Wens {
	
	@Override
	public void culture() {
		System.out.println("这是温氏养殖的鸡肉!!!");
		System.out.println(super.name+Wens.brand);
		
	}
	
}
