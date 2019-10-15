package cn.edu.scau.cmi.longting.factory;

import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Chicken;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Meat;

public class ChickenMeatFactory implements MeatFactory {

	@Override
	public Meat getMeat() {
		return new Chicken();
	}

}
