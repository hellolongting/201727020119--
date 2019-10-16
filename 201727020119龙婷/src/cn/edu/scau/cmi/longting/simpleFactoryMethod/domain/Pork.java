package cn.edu.scau.cmi.longting.simpleFactoryMethod.domain;

public class Pork extends Meat{

	private String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String cook() {
//		System.out.println("pork is marvelous!!!");
		return "pork is marvelous!!!";
	}
	
}
