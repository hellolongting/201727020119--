package cn.edu.scau.cmi.longting.fxml.abstractFactory;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Meats;
import cn.edu.scau.cmi.longting.abstractFactory.factory.AbstractFactory;
import cn.edu.scau.cmi.longting.abstractFactory.factory.AonongFactory;
import cn.edu.scau.cmi.longting.abstractFactory.factory.TianbangFactory;
import cn.edu.scau.cmi.longting.abstractFactory.factory.WensFactory;
import cn.edu.scau.cmi.longting.factory.BeefMeatFactory;
import cn.edu.scau.cmi.longting.factory.ChickenMeatFactory;
import cn.edu.scau.cmi.longting.factory.PorkMeatFactory;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.MeatFactory;
import cn.edu.scau.cmi.longting.simpleFactoryMethod.domain.Meat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

public class abstractFactoryController {

	@FXML
	private TextField simpleFactoryInput;

	@FXML
	private TextField factoryInput;
	
	@FXML
	private TextField abstractFactoryInput1;
	
	@FXML
	private TextField abstractFactoryInput2;
	
	@FXML
	private Label simpleFactoryOutput;

	@FXML
	private Label factoryOutput;
	
	@FXML
	private Label abstractFactoryOutput;
	
	@FXML
	public void simpleFactoryEnsure(ActionEvent event) {
		String meatString = simpleFactoryInput.getText();
		simpleFactoryOutput.setText(simpleFactoryOutput.getText()
				+(MeatFactory.getMeat(meatString) != null ? MeatFactory.getMeat(meatString).cook() : "输入错误！")
				+"\n");
	}
	
	@FXML
	public void factoryEnsure(ActionEvent event) {
		String meatString = factoryInput.getText();
		factoryOutput.setText(factoryOutput.getText()
				+(MeatFactory.getMeat(meatString) != null ? MeatFactory.getMeat(meatString).cook() : "输入错误！")
				+"\n");
	}
	/*
	private String getFactoryOut(String meatString) {
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
	}
	*/
	
	@FXML
	public void abstractFactoryEnsure(ActionEvent event) {
//		1. 选择品牌
		String brandKind = abstractFactoryInput1.getText();
		AbstractFactory abstractFactory = null;

		switch (brandKind) {
		case "wens":
			abstractFactory = new WensFactory();
			break;
		case "tianbang":
			abstractFactory = new TianbangFactory();
			break;
		case "aonong":
			abstractFactory = new AonongFactory();
			break;
		default:
//			System.out.println("sorry, your input is not correct!");
			abstractFactoryOutput.setText(abstractFactoryOutput.getText()+"sorry, your input is not correct!"+"\n");
			return;
		}
		
//		选择肉类型
		String meatKind = abstractFactoryInput2.getText();
		Meats meats = null;
		switch (meatKind) {
		case "pork":
			meats = abstractFactory.culturePork();
			break;
		case "beef":
			meats = abstractFactory.cultureBeef();
			break;
		case "chicken":
			meats = abstractFactory.cultureChicken();
			break;
		default:
//			System.out.println("sorry, your input is not correct!");
			abstractFactoryOutput.setText(abstractFactoryOutput.getText()+"sorry, your input is not correct!"+"\n");
			return;
		}
		
		abstractFactoryOutput.setText(abstractFactoryOutput.getText()+meats.culture()+"\n");
		
	}

}
