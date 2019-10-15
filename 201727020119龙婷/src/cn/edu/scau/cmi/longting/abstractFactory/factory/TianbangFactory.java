package cn.edu.scau.cmi.longting.abstractFactory.factory;

import cn.edu.scau.cmi.longting.abstractFactory.domain.TianbangBeef;
import cn.edu.scau.cmi.longting.abstractFactory.domain.TianbangChicken;
import cn.edu.scau.cmi.longting.abstractFactory.domain.TianbangPork;
import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Meats;

public class TianbangFactory extends AbstractFactory {

	@Override
	public Meats culturePork() {
		return new TianbangPork();
	}

	@Override
	public Meats cultureBeef() {
		return new TianbangBeef();
	}

	@Override
	public Meats cultureChicken() {
		return new TianbangChicken();
	}

}
