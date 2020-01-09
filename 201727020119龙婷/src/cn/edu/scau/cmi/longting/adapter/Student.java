package cn.edu.scau.cmi.longting.adapter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
	private IntegerProperty number = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty();
	public int getNumber() {
		return number.get();
	}
	public void setNumber(int number) {
//		System.out.println("number : "+number);
		this.number.set(number);
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);;
	}
}
