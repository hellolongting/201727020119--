package cn.edu.scau.cmi.longting.client;

import java.util.Scanner;

import cn.edu.scau.cmi.longting.abstractFactory.domainAbstractClass.Meats;
import cn.edu.scau.cmi.longting.abstractFactory.factory.AbstractFactory;
import cn.edu.scau.cmi.longting.abstractFactory.factory.AonongFactory;
import cn.edu.scau.cmi.longting.abstractFactory.factory.TianbangFactory;
import cn.edu.scau.cmi.longting.abstractFactory.factory.WensFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AbstractFactoryClient extends Application {

	public static void main(String[] args) {
		launch(args);
		
//		1. 选择品牌
		System.out.println("Please select which brand you want to buy: wens, tianbang or aonong???");
		Scanner scanner = new Scanner(System.in);
		String brandKind = scanner.next();
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
			System.out.println("sorry, your input is not correct!");
			break;
		}
//		2. 选择肉类型
		System.out.println("Please select which meat you want to buy: pork, beef or chicken???");
		String meatKind = scanner.next();
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
			System.out.println("sorry, your input is not correct!");
			break;
		}
		
		if(meats != null) {
			meats.culture();
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {  
		Parent root = FXMLLoader.load(getClass().getResource("/cn/edu/scau/cmi/longting/fxml/abstractFactory/AbstractFactory.fxml"));
		Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("abstractFactory");
	    primaryStage.show();
		
	}
	
}
