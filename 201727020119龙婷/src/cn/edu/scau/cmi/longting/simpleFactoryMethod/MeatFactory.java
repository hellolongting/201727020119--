package cn.edu.scau.cmi.longting.simpleFactoryMethod;

import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Beef;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Chicken;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Meat;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Pork;

public class MeatFactory {
	public static Meat getMeat(String meatTypeString) {
		Meat meat = null;
		switch (meatTypeString) {
		case "beef":
			meat = new Beef();break;
		case "pork":
			meat = new Pork();break;
		case "chicken":
			meat = new Chicken();break;
		}
		return meat;
	}

}
