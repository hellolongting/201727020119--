package cn.edu.scau.cmi.longting.abstractFactory.factory;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Meats;

public abstract class AbstractFactory {
	public static AbstractFactory getFactory(String brand) {
		switch (brand) {
		case "wens":
			return new WensFactory();
		case "tianbang":
			return new TianbangFactory();
		case "aonong":
			return new AonongFactory();
		}
		return null;
	}
	
	public abstract Meats culturePork();
	public abstract Meats cultureBeef();
	public abstract Meats cultureChicken();

}
