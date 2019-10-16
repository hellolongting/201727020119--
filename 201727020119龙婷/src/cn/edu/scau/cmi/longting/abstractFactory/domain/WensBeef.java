package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Beef;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Wens;

public class WensBeef extends Beef implements Wens {
	
	@Override
	public String culture() {
		System.out.println("这是温氏养殖的牛肉!!!");
		System.out.println(super.name+Wens.brand);
		return "这是温氏养殖的牛肉!!!";
	}
	
}
