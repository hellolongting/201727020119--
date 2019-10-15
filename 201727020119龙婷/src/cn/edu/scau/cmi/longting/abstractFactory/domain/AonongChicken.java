package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Chicken;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Aonong;

public class AonongChicken extends Chicken implements Aonong {

	@Override
	public void culture() {
		System.out.println("这是傲农养殖的鸡肉!!!");
		System.out.println(super.name+Aonong.brand);
		
	}
	
}
