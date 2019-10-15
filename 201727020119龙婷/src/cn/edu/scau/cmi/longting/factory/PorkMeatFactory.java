package cn.edu.scau.cmi.longting.factory;

import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Meat;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Pork;

public class PorkMeatFactory implements MeatFactory {

	@Override
	public Meat getMeat() {
		return new Pork();
	}

}
