package cn.edu.scau.cmi.longting.factory;

import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Beef;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Meat;

public class BeefMeatFactory implements MeatFactory {

	@Override
	public Meat getMeat() {
		return new Beef();
	}

}
