package cn.edu.scau.cmi.longting.abstractFactory.factory;

import cn.edu.scau.cmi.longting.abstractFactory.domain.WensBeef;
import cn.edu.scau.cmi.longting.abstractFactory.domain.WensChicken;
import cn.edu.scau.cmi.longting.abstractFactory.domain.WensPork;
import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Meats;

public class WensFactory extends AbstractFactory {

	@Override
	public Meats culturePork() {
		return new WensPork();
	}

	@Override
	public Meats cultureBeef() {
		return new WensBeef();
	}

	@Override
	public Meats cultureChicken() {
		return new WensChicken();
	}

}
