package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Beef;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Aonong;

public class AonongBeef extends Beef implements Aonong {

	@Override
	public void culture() {
		System.out.println("这是傲农养殖的牛肉!!!");
		System.out.println(super.name+Aonong.brand);
		
	}
	
}
