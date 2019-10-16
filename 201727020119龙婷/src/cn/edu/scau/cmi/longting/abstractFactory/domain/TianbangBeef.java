package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Beef;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Tianbang;

public class TianbangBeef extends Beef implements Tianbang {

	@Override
	public String culture() {
		System.out.println("这是天邦养殖的牛肉!!!");
		System.out.println(super.name+Tianbang.brand);
		return "这是天邦养殖的牛肉!!!";
	}
	
}
