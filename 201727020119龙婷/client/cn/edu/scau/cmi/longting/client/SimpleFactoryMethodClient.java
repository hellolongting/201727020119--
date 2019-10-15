package cn.edu.scau.cmi.longting.client;

import cn.edu.scau.cmi.longting.simpleFactoryMethod.MeatFactory;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Meat;

public class SimpleFactoryMethodClient {

	public static void main(String[] args) {
		
		Meat beef = MeatFactory.getMeat("beef");
		beef.cook();
		
		Meat pork = MeatFactory.getMeat("pork");
		pork.cook();
		
		Meat chicken = MeatFactory.getMeat("chicken");
		chicken.cook();
		
	}

}
