package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Pork;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Aonong;

public class AonongPork extends Pork implements Aonong {

	@Override
	public void culture() {
		System.out.println("这是傲农养殖的猪肉!!!");
		System.out.println(super.name+Aonong.brand);
		
	}
	
}
