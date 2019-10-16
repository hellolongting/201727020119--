package cn.edu.scau.cmi.longting.client;

import java.util.Scanner;

import cn.edu.scau.cmi.longting.factory.BeefMeatFactory;
import cn.edu.scau.cmi.longting.factory.ChickenMeatFactory;
import cn.edu.scau.cmi.longting.factory.MeatFactory;
import cn.edu.scau.cmi.longting.factory.PorkMeatFactory;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Meat;

public class FactoryClient {

	public static void main(String[] args) {
		System.out.println("Please select which kind of meat you want to eat: beef or pork or chicken???");
		Scanner scanner = new Scanner(System.in);
		String meatString = scanner.next();
		MeatFactory meatFactory = null;
		switch (meatString) {
		case "beef":
			meatFactory = new BeefMeatFactory();
			break;
		case "pork":
			meatFactory = new PorkMeatFactory();
			break;
		case "chicken":
			meatFactory = new ChickenMeatFactory();
			break;
		default:
			System.out.println("sorry, your input is not correct!");
			break;
		}
		if(meatFactory != null) {
			Meat meat = meatFactory.getMeat();
			System.out.println(meat.cook());;
		}
	}
	
}
