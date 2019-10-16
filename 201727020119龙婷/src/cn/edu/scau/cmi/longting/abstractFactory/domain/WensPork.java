package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Pork;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Wens;

public class WensPork extends Pork implements Wens {

	@Override
	public String culture() {
		System.out.println("这是温氏养殖的猪肉!!!");
		System.out.println(super.name+Wens.brand);
		return "这是温氏养殖的猪肉!!!";
	}
	
}
