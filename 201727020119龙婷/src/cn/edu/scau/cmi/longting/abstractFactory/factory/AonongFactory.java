package cn.edu.scau.cmi.longting.abstractFactory.factory;

import cn.edu.scau.cmi.longting.abstractFactory.domain.AonongBeef;
import cn.edu.scau.cmi.longting.abstractFactory.domain.AonongChicken;
import cn.edu.scau.cmi.longting.abstractFactory.domain.AonongPork;
import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Meats;

public class AonongFactory extends AbstractFactory {

	@Override
	public Meats culturePork() {
		return new AonongPork();
	}

	@Override
	public Meats cultureBeef() {
		return new AonongBeef();
	}

	@Override
	public Meats cultureChicken() {
		return new AonongChicken();
	}

}
