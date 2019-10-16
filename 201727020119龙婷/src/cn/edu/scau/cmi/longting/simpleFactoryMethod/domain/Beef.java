package cn.edu.scau.cmi.longting.simpleFactoryMethod.domain;

public class Beef extends Meat {

	private String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String cook() {
//		System.out.println("beef is marvelous!!!");
		return "beef is marvelous!!!";
	}
	
}
