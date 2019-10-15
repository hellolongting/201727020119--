package cn.edu.scau.cmi.longting.abstractFactory.domain;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Pork;
import cn.edu.scau.cmi.longting.abstractFactory.domainInterface.Tianbang;

public class TianbangPork extends Pork implements Tianbang {

	@Override
	public void culture() {
		System.out.println("这是天邦养殖的猪肉!!!");
		System.out.println(super.name+Tianbang.brand);
		
	}
	
}
